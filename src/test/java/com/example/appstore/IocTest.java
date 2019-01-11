package com.example.appstore;

import com.example.appstore.config.BeanConfiguration;
import com.example.appstore.container.BeanDefiniation;
import com.example.appstore.container.BeanDefiniationRegistor;
import com.example.appstore.service.ZygxService;

import java.lang.reflect.InvocationTargetException;

public class IocTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new BeanConfiguration().loadBean();
        BeanDefiniation beanDefiniation=BeanDefiniationRegistor.getBeanDefiniation("zygxService");
        ZygxService zygxService=(ZygxService)beanDefiniation.getData();
        zygxService.test();
    }
}
