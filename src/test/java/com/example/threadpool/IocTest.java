package com.example.threadpool;

import com.example.threadpool.annation.AppInject;
import com.example.threadpool.config.BeanConfiguration;
import com.example.threadpool.container.BeanDefiniation;
import com.example.threadpool.container.BeanDefiniationRegistor;
import com.example.threadpool.service.ZygxService;

import java.lang.reflect.InvocationTargetException;

public class IocTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new BeanConfiguration().loadBean();
        BeanDefiniation beanDefiniation=BeanDefiniationRegistor.getBeanDefiniation("zygxService");
        ZygxService zygxService=(ZygxService)beanDefiniation.getData();
        zygxService.test();
    }
}
