package com.example.appstore.service;

import com.example.appstore.annation.AppBean;
import com.example.appstore.annation.AppInject;

@AppBean(name = "zygxService")
public class ZygxService {
    @AppInject(name="myService")
    private MyService service;

    public void setService(MyService service) {
        this.service = service;
    }

    public void test(){
        service.printUsage();
        service.showUsage();
    }
}
