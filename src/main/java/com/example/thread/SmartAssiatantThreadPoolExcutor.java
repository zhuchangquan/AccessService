package com.example.thread;

import java.util.concurrent.*;

/**
 * 用于处理一般对接业务的线程池组件
 */
public class SmartAssiatantThreadPoolExcutor extends ThreadPoolExecutor {
    private static final String PRFIX_NAMW = "hivoice-Access";

    private static final String POOL_NAME = "business";

    public SmartAssiatantThreadPoolExcutor(int corePoolSize,
                                           int maximumPoolSize,
                                           long keepAliveTime,
                                           int workQueueNum,
                                           RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(workQueueNum), new CatagoryThreadFactory(PRFIX_NAMW,POOL_NAME), rejectedExecutionHandler);
    }
}
