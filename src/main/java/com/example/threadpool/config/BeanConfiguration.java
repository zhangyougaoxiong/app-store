package com.example.threadpool.config;

import com.example.threadpool.factory.AppProxyFactoryBean;
import com.example.threadpool.service.UserService;
import com.example.threadpool.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfiguration {

    @Bean(name = "userService")
    public UserService userService(){
        AppProxyFactoryBean factoryBean=new AppProxyFactoryBean<UserService>();
        factoryBean.setTargetClass(UserServiceImpl.class);
        return (UserService) factoryBean.getObject();
    }
}
