package com.example.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class XunFeiThreadPoolExecutor extends ThreadPoolExecutor {
    private static final String PRFIX_NAMW = "hivoice-access";

    private static final String POOL_NAME = "xunfei";

    public XunFeiThreadPoolExecutor(int corePoolSize,
                                           int maximumPoolSize,
                                           long keepAliveTime,
                                           int workQueueNum,
                                           RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(workQueueNum), new CatagoryThreadFactory(PRFIX_NAMW,POOL_NAME), rejectedExecutionHandler);
    }

}
