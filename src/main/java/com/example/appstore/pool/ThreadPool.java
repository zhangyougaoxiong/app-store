package com.example.appstore.pool;

import com.example.appstore.util.ThreadPoolUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;

@Configuration
public class ThreadPool {

    @Bean(destroyMethod = "shutdown")
    public ExecutorService getThreadPool(){
        return ThreadPoolUtils.createThreadPool(10,"thread-pool");
    }
}
