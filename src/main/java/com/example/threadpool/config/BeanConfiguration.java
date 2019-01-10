package com.example.threadpool.config;

import com.example.threadpool.factory.AppProxyFactoryBean;
import com.example.threadpool.service.UserService;
import com.example.threadpool.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zygx
 */
@Component
public class BeanConfiguration {

    @Bean(name = "userServiceFactoryBean")
    public UserService userService(){
        AppProxyFactoryBean<UserServiceImpl> factoryBean=new AppProxyFactoryBean<>();
        factoryBean.setTargetClass(UserServiceImpl.class);
        return  factoryBean.getObject();
    }
}
