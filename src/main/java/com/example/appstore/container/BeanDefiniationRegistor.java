package com.example.appstore.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zygx
 */
public class BeanDefiniationRegistor {

    public final static Map<String,BeanDefiniation> beanDefiniationMap=new ConcurrentHashMap<>();
    private static final ReentrantLock BEAN_DEFINATION_LOCK=new ReentrantLock();

    public static BeanDefiniation getBeanDefiniation(String key){
        return beanDefiniationMap.get(key);
    }

    public static void registerBeanDefiniation(String key,BeanDefiniation beanDefiniation){
        if(!beanDefiniationMap.containsKey(key)){
            try{
                BEAN_DEFINATION_LOCK.lock();
                beanDefiniationMap.put(key,beanDefiniation);
            }finally {
                BEAN_DEFINATION_LOCK.unlock();
            }

        }
    }
}
