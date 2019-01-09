package com.example.threadpool.factory;

import com.example.threadpool.proxy.AppEnhanceProxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * @author zygx
 * @param <T>
 */
public class AppProxyFactoryBean<T> implements InitializingBean, FactoryBean<T> {

    private Class<T> targetClass;

    public void setTargetClass(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    @Override
    public T getObject() {
        AppEnhanceProxy proxy=new AppEnhanceProxy(targetClass);
        System.out.println("getObject...");
        return (T) proxy.getProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return targetClass;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(targetClass,"targetClass不能为空");
    }
}
