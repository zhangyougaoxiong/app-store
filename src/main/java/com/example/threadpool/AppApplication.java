package com.example.threadpool;

import com.example.threadpool.config.AppProxyConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author zygx
 */
@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(value = AppProxyConfiguration.class)
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(AppApplication.class);
        StringBuffer sb=new StringBuffer();
        sb.append("\n===========================================\n");
        sb.append("============ APP thread pool===============\n");
        sb.append("===========================================");
        springApplication.setBanner((environment, sourceClass, out) -> out.println(sb.toString()));
        springApplication.setBannerMode(Banner.Mode.LOG);
        springApplication.addListeners((ApplicationListener<ApplicationEvent>) applicationEvent -> log.info("system app thread pool start..."));
        springApplication.run(args);
    }

}

