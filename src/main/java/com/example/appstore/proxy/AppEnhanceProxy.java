package com.example.appstore.proxy;

import com.example.appstore.help.AppProxyRepository;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.Assert;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author zygx
 * @param <T>
 */
public class AppEnhanceProxy<T> implements appProxy<T> {

    private Class<T> targetClass;

    public AppEnhanceProxy(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T getProxy() {
        validate();
        return getProxyInternal();
    }

    private void validate(){
        Assert.notNull(targetClass,"targetClass不能为空");
        if(Modifier.isFinal(targetClass.getModifiers())){
            throw new IllegalStateException("final 修饰方法不能进行代理");
        }
        if(!Modifier.isPublic(targetClass.getModifiers())){
            throw new IllegalStateException("非public方法不能进行代理");
        }
    }

    public T getProxyInternal(){
        Class proxyClass= AppProxyRepository.getProxy(targetClass.getName());
        if(proxyClass==null){
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(targetClass);
            enhancer.setCallbackTypes(new Class[]{AppInterceptor.class});
            proxyClass=enhancer.createClass();
            AppProxyRepository.registerRepository(targetClass.getName(),proxyClass);
        }
        try {
            Enhancer.registerCallbacks(proxyClass,new Callback[]{new AppInterceptor()});
            return (T) proxyClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    class AppInterceptor implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("这里我可以做点事情");
            return methodProxy.invokeSuper(o,args);
        }
    }
}
