package com.example.appstore.container;

import com.example.appstore.annation.AppInject;
import com.example.appstore.util.ClassTools;
import com.example.appstore.annation.AppBean;
import org.springframework.beans.BeansException;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**
 * @author zygx
 */
public class DefaultAppBeanFactory extends AbstractAppBeanFactory {

    public static void registerBean(String beanName, boolean isSingleton, Class beanClass,Object data) {
        BeanDefiniation beanDefiniation = new BeanDefiniation();
        beanDefiniation.build().isSingleton(isSingleton)
                .beanName(beanName).beanClass(beanClass).data(data);
        BeanDefiniationRegistor.registerBeanDefiniation(beanName, beanDefiniation);
    }

    @Override
    public Object getBean(String s) throws BeansException {
        BeanDefiniation beanDefiniation = BeanDefiniationRegistor.getBeanDefiniation(s);
        Class clazz = beanDefiniation.getBeanClass();
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadBeanDefinition(){
        Set<Class<?>> set=ClassTools.getClasses("com.example.appstore");
        set.forEach(aClass -> {
            if(aClass.isAnnotationPresent(AppBean.class)){
                try {
                    AppBean appBean=aClass.getAnnotation(AppBean.class);
                    String beanName=appBean.name();
                    registerBean(beanName,true,aClass,aClass.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void setBeanFiled() throws InvocationTargetException, IllegalAccessException {
        Map map=BeanDefiniationRegistor.beanDefiniationMap;
        if(!CollectionUtils.isEmpty(map)){
            Set<Map.Entry<String, BeanDefiniation>> set=map.entrySet();
            for(Map.Entry<String, BeanDefiniation> entry:set){
                BeanDefiniation beanDefiniation=entry.getValue();
                Field[]fields=beanDefiniation.getBeanClass().getDeclaredFields();
                for(Field field:fields){
                    if(field.getAnnotation(AppInject.class)!=null){
                        String injectBeanName=field.getAnnotation(AppInject.class).name();
                        BeanDefiniation injectBean=BeanDefiniationRegistor.getBeanDefiniation(injectBeanName);
                        Method[] methods=field.getDeclaringClass().getMethods();
                        for(Method m:methods){
                            if(m.getName().contains("set")){
                                m.invoke(beanDefiniation.getData(),injectBean.getData());
                                registerBean(beanDefiniation.getBeanName(),true,
                                        beanDefiniation.getBeanClass(),beanDefiniation.getData());
                            }
                        }
                    }
                }
            }
        }
    }
}
