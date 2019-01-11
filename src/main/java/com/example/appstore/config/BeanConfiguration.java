package com.example.appstore.config;

import com.example.appstore.container.DefaultAppBeanFactory;
import com.example.appstore.factory.AppProxyFactoryBean;
import com.example.appstore.service.UserService;
import com.example.appstore.service.impl.UserServiceImpl;
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
