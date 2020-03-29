package com.example.server.impl;

import com.example.constant.HttpConfig;
import com.example.model.TerminalContext;
import com.example.server.GetParser;
import com.example.server.PostParser;
import com.example.utils.SpringBeanUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;


/**
 * 1.云测会做负载均衡，所以接受到请求是nginx请求
 * 2.该类为自定义netty处理器，用来处理nginx转发过来的请求
 * 3.针对网络事件，分别重写了channelRead0、channelActive、channelInActive等方法
 * 4.userEventTriggered是netty提供的心跳检测机制定义的方法，可以用来处理读、写、读写空闲事件
 */
@Slf4j
public class ProxyConnection extends SimpleChannelInboundHandler<HttpObject> {

    PostParser postParser;

    GetParser getParser;

    public ProxyConnection() {
        postParser = SpringBeanUtil.getMultiPartBodyParserInstance();
        getParser = SpringBeanUtil.getGetParserInstance();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        //构造终端上下文对象
        TerminalContext terminalContext = buiderContext(ctx);
        if(msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            log.info("请求方法:" + httpRequest.method().name());
            if(HttpConfig.GET.equals(httpRequest.method().name())) {
               //初始化相关资源
               postParser.init(httpRequest);
            }
            parseHttpHeader(terminalContext, httpRequest);
        } else if(msg instanceof HttpContent) {
            HttpContent httpContent = (HttpContent) msg;
            parseHttpBody(terminalContext, httpContent);
        } else {
            log.info("请求不合法");
        }
    }

    private void parseHttpHeader(TerminalContext terminalContext, HttpRequest httpRequest) {
        getParser.parserHeader(terminalContext, httpRequest);
    }

    private void parseHttpBody(TerminalContext terminalContext,HttpContent httpContent) {
        postParser.parserBody(terminalContext, httpContent);
    }


    private TerminalContext buiderContext(ChannelHandlerContext ctx){
        TerminalContext terminalContext = new TerminalContext();
        terminalContext.setChannel(ctx.channel());
        return terminalContext;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("channel Active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
        super.channelInactive(ctx);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        //netty所提供的空闲检测机制
        super.userEventTriggered(ctx, evt);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        log.info("捕获到了异常：" + cause.getMessage());
    }
}
