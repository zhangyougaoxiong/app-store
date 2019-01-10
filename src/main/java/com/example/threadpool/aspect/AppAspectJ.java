package com.example.threadpool.aspect;
import com.example.threadpool.container.DefaultAppBeanFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zygx
 */
@Component
@Aspect
public class AppAspectJ {

//    @Around(value="execution (* com.example.threadpool.container.DefaultAppBeanFactory.loadBeanDefinition())")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("/=============aspectJ=============/");
//        Object obj=pjp.proceed();
//        DefaultAppBeanFactory.setBeanFiled();
//        return obj;
//    }
}
