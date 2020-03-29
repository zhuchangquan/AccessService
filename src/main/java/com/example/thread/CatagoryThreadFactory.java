package com.example.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 种类线程工厂，用来创建不同的业务线程
 */
public class CatagoryThreadFactory implements ThreadFactory {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private String poolName;

    private String prefix;

    public CatagoryThreadFactory(String poolName, String prefix) {
        this.poolName = poolName;
        this.prefix = prefix;
    }


    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(prefix+"-"+ poolName + "-" + atomicInteger.getAndIncrement());
        thread.setUncaughtExceptionHandler(null);
        return thread;
    }
}
