package com.example.threadpool.help;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zygx
 */
public class AppProxyRepository {

    /**proxy仓库,避免重复创建对应的class*/
    private static final Map<String,Class > repository=new ConcurrentHashMap<>();

    public static Class getProxy(String key){
        return repository.get(key);
    }

    public static void registerRepository(String key,Class proxyClass){
        if(!repository.containsKey(key)){
            synchronized (repository){
                if(!repository.containsKey(key)){
                    repository.put(key,proxyClass);
                }
            }
        }
    }
}
