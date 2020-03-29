package com.example.server;

import com.example.model.TerminalContext;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;

/**
 * POST请求的解析器
 */
public interface PostParser {

    /**
     * 初始化相关资源
     */
    void init(HttpRequest httpRequest);

    /**
     *
     * @param terminalContext 终端数据上下文对象
     * @param httpContent netty组件对http请求body解码后封装的一个对象
     */
    void parserBody(TerminalContext terminalContext, HttpContent httpContent);

    /**
     * 释放相关资源
     */
    void release();
}
