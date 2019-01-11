package com.example.appstore.aspect;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author zygx
 */
@Component
@Aspect
public class AppAspectJ {

//    @Around(value="execution (* com.example.appstore.container.DefaultAppBeanFactory.loadBeanDefinition())")
//    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("/=============aspectJ=============/");
//        Object obj=pjp.proceed();
//        DefaultAppBeanFactory.setBeanFiled();
//        return obj;
//    }
}
