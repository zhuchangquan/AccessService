package com.example.server.impl;


import com.example.config.ConfigCenter;
import com.example.server.NettyBootStrap;
import com.example.server.NettyEventLoopGruop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DefaultServerImpl implements NettyBootStrap {

    @Autowired
    NettyEventLoopGruop nettyEventLoopGruop;

    @Autowired
    ConfigCenter configCenter;

    @Override
    @PostConstruct
    public void start() {
        init();
    }

    private void init() {
        EventLoopGroup acceptorGroup = nettyEventLoopGruop.getAcceptorNioEventLoopGroup();
        EventLoopGroup workGroup = nettyEventLoopGruop.getWorkerNioEventLoopGroup();

        //netty服务端启动类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(acceptorGroup,workGroup).channel(NioServerSocketChannel.class).
                childHandler(new DefaultServerInitializer());

        //netty服务绑定端口
        int proxyPort = Integer.parseInt(configCenter.getPort());
        ChannelFuture channelFuture = serverBootstrap.bind(proxyPort);
        log.info("netty bind port:" + proxyPort);

        Throwable cause = channelFuture.cause();
        log.info("netty httpServer start success" );
    }


    private static class DefaultServerInitializer extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            ChannelPipeline pipeline = socketChannel.pipeline();

            //netty所提供的http编解码器
            pipeline.addLast("HttpServerCodec",new HttpServerCodec());

            //添加自定义处理器
            pipeline.addLast("ProxyConnection", new ProxyConnection());
        }
    }


}
