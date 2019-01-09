package com.example.threadpool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import javax.annotation.PostConstruct;

/**
 * @author zygx
 */
@ConfigurationProperties(prefix = "app.proxy")
public class AppProxyConfiguration {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @PostConstruct
    public void init(){
        System.out.println(id);
    }

}
