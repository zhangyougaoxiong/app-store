package com.example.threadpool;

import com.example.threadpool.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadpoolApplicationTests {

    @Autowired
    ExecutorService executorService;

    @Test
    public void contextLoads() {
        for (int i=0;i<100;i++){
            executorService.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
    }

    //----------------------test------------------------
   @Resource(name = "userServiceFactoryBean")
    UserService service;
    @Test
    public void test(){
        service.printUsage();
    }

}

