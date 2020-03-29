package com.example.server;

import com.example.model.TerminalContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * GET请求的解析器
 */
public interface GetParser {

    /**
     *
     * @param terminalContext 终端数据上下文对象
     * @param httpRequest netty组件对http请求头部信息解码后封装的一个对象
     */
    void parserHeader(TerminalContext terminalContext, HttpRequest httpRequest);

}
