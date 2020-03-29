package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class ConfigCenter {

    @Value("${proxy.port}")
    private String port;

    @Value("${aivoice.smartCorePoolSize}")
    private String smartCorePoolSize;

    @Value("${aivoice.smartMaximumPoolSize}")
    private String smartMaximumPoolSize;

    @Value("${aivoice.smartKeepAlive}")
    private String smartKeepAlive;

    @Value("${aivoice.smartBlockingQueueSize}")
    public String blockingQueueSize;

    @Value("${proxy.nettyAcceptorThreadSize}")
    public String nettyAcceptorThreadSize;

    @Value("${proxy.nettyWorkerThreadSize}")
    public String nettyWorkerThreadSize;
}
