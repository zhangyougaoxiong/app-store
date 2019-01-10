package com.example.threadpool.container;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.ResolvableType;
import static com.example.threadpool.container.BeanDefiniationRegistor.getBeanDefiniation;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author zygx
 */
public abstract class AbstractAppBeanFactory implements AppBeanFactory {
    @Override
    public boolean containsBeanDefinition(String s) {
        return getBeanDefiniation(s)!=null;
    }

    @Override
    public int getBeanDefinitionCount() {
        return BeanDefiniationRegistor.beanDefiniationMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return (String[]) BeanDefiniationRegistor.beanDefiniationMap.keySet().toArray();
    }

    @Override
    public String[] getBeanNamesForType(ResolvableType resolvableType) {
        return new String[0];
    }

    @Override
    public String[] getBeanNamesForType(Class<?> aClass) {
        return null;
    }

    @Override
    public String[] getBeanNamesForType(Class<?> aClass, boolean b, boolean b1) {
        return null;
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> aClass, boolean b, boolean b1) throws BeansException {
        return null;
    }

    @Override
    public String[] getBeanNamesForAnnotation(Class<? extends Annotation> aClass) {
        return new String[0];
    }

    @Override
    public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> aClass) throws BeansException {
        return null;
    }

    @Override
    public <A extends Annotation> A findAnnotationOnBean(String s, Class<A> aClass) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public Object getBean(String s) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public Object getBean(String s, Object... objects) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
        return null;
    }

    @Override
    public <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
        return null;
    }

    @Override
    public boolean containsBean(String s) {
        return containsBeanDefinition(s);
    }

    @Override
    public boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        BeanDefiniation beanDefiniation=getBeanDefiniation(s);
        return beanDefiniation.isSingleton();
    }

    @Override
    public boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return !isSingleton(s);
    }

    @Override
    public boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return false;
    }

    @Override
    public Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return null;
    }

    @Override
    public String[] getAliases(String s) {
        return null;
    }
}
