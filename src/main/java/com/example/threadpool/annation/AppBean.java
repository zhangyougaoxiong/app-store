package com.example.threadpool.annation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AppBean {

    String name() default "";
}
