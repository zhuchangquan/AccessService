package com.example.server.impl;

import com.example.config.ConfigCenter;
import com.example.server.NettyEventLoopGruop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NettyEventLoopGroupImpl implements NettyEventLoopGruop {

    @Autowired
    ConfigCenter configCenter;

    @Override
    public EventLoopGroup getAcceptorNioEventLoopGroup() {
        EventLoopGroup accept = new NioEventLoopGroup(Integer.parseInt(configCenter.getNettyAcceptorThreadSize()));
        return accept;
    }

    @Override
    public EventLoopGroup getWorkerNioEventLoopGroup() {
        EventLoopGroup worker = new NioEventLoopGroup(Integer.parseInt(configCenter.getNettyWorkerThreadSize()));
        return worker;
    }
}
