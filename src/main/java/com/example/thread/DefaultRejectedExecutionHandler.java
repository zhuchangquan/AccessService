package com.example.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 默认的线程池拒绝处理器，用于记录线程池中一些关键指标
 */
@Component("defaultRejectedExecutionHandler")
@Slf4j
public class DefaultRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.info("coresize:" + executor.getCorePoolSize());
        log.info("maxPoolSize:" + executor.getMaximumPoolSize());
        log.info("activeCount:" + executor.getActiveCount());
    }
}
