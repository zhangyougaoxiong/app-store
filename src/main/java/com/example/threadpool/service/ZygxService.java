package com.example.threadpool.service;

import com.example.threadpool.annation.AppBean;
import com.example.threadpool.annation.AppInject;

@AppBean(name = "zygxService")
public class ZygxService {
    @AppInject(name="myService")
    private MyService service;

    public void setService(MyService service) {
        this.service = service;
    }

    public void test(){
        service.printUsage();
    }
}
