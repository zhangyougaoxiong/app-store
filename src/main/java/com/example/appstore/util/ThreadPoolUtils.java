package com.example.appstore.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * the common util is used for creating thread pool
 * @see ThreadPoolExecutor
 * @see ExecutorService
 * @author zygx
 * @date 2019/01/08
 */
public class ThreadPoolUtils {

    /**
     * the usage of creating threadPool
     * @param nThreads the number of threads you want to create
     * @param threadName the threadName prefix
     * @return
     */
    public static ExecutorService createThreadPool(int nThreads, final String threadName){
        ExecutorService executorService=new ThreadPoolExecutor(nThreads, 100, 5, TimeUnit.MINUTES,
                new LinkedBlockingQueue<>(), new ThreadFactory() {

            private AtomicInteger count=new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"["+threadName+"-"+count.getAndIncrement()+"]");
            }
        });
        return executorService;
    }
}
