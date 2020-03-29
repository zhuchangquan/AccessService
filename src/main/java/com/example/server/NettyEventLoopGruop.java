package com.example.server;

import io.netty.channel.EventLoopGroup;

/**
 * 用于获取netty组件的事件循环组,通常有两个acceptor和worker
 * 一个负责处理连接，一个负责工作
 */
public interface NettyEventLoopGruop {

    EventLoopGroup getAcceptorNioEventLoopGroup();

    EventLoopGroup getWorkerNioEventLoopGroup();
}
