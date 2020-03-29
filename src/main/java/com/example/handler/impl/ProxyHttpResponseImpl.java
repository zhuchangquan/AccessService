package com.example.handler.impl;

import com.example.handler.ProxyHttpResponse;
import com.example.model.TerminalContext;
import com.example.listener.DefaultFutureListener;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ProxyHttpResponseImpl implements ProxyHttpResponse {


    @Override
    public void write(TerminalContext terminalContext) {
        Channel channel = terminalContext.getChannel();
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,byteBuf);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE,"text/plain");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH,byteBuf.readableBytes());
        if (channel.isActive()){
            channel.writeAndFlush(response).addListener(new DefaultFutureListener(terminalContext));
        } else {
            log.info("channel is Inactive");
        }
    }
}
