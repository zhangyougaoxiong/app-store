package com.example.threadpool.config;

import com.example.threadpool.container.DefaultAppBeanFactory;
import com.example.threadpool.factory.AppProxyFactoryBean;
import com.example.threadpool.service.UserService;
import com.example.threadpool.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;

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

    @PostConstruct
    public void loadBean() throws InvocationTargetException, IllegalAccessException {
        DefaultAppBeanFactory.loadBeanDefinition();
        DefaultAppBeanFactory.setBeanFiled();
    }

}
