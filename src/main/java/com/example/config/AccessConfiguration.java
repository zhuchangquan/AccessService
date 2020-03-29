package com.example.config;

import com.example.thread.DefaultRejectedExecutionHandler;
import com.example.thread.SmartAssiatantThreadPoolExcutor;
import com.example.thread.XunFeiThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AccessConfiguration {

    @Autowired
    ConfigCenter configCenter;

    @Autowired
    @Qualifier("defaultRejectedExecutionHandler")
    DefaultRejectedExecutionHandler rejectedExecutionHandler;

    @Bean
    public SmartAssiatantThreadPoolExcutor getSmartAssiatantThreadPoolExcutor() {
        int smartCoreSize = Integer.parseInt(configCenter.getSmartCorePoolSize());
        int smartMaximumPoolSize = Integer.parseInt(configCenter.getSmartMaximumPoolSize());
        long smartKeepAlive = Integer.parseInt(configCenter.getSmartKeepAlive());
        int smartBlockingQueueSize = Integer.parseInt(configCenter.getBlockingQueueSize());
        SmartAssiatantThreadPoolExcutor assiatantThreadPoolExcutor =
                new SmartAssiatantThreadPoolExcutor(smartCoreSize,smartMaximumPoolSize,smartKeepAlive,smartBlockingQueueSize,rejectedExecutionHandler);
        log.info("smartAssiatantThreadPoolExcutor 注入完成");
        return assiatantThreadPoolExcutor;
    }

    @Bean
    public XunFeiThreadPoolExecutor getXunFeiThreadPoolExecutor() {
        int smartCoreSize = Integer.parseInt(configCenter.getSmartCorePoolSize());
        int smartMaximumPoolSize = Integer.parseInt(configCenter.getSmartMaximumPoolSize());
        long smartKeepAlive = Integer.parseInt(configCenter.getSmartKeepAlive());
        int smartBlockingQueueSize = Integer.parseInt(configCenter.getBlockingQueueSize());
        XunFeiThreadPoolExecutor xunFeiThreadPoolExecutor =
                new XunFeiThreadPoolExecutor(smartCoreSize,smartMaximumPoolSize,smartKeepAlive,smartBlockingQueueSize,rejectedExecutionHandler);
        log.info("xunFeiThreadPoolExecutor 注入完成");
        return xunFeiThreadPoolExecutor;
    }
}
