package com.example.handler;


import com.example.model.TerminalContext;

/**
 * 给端测响应的一个处理类
 */
public interface ProxyHttpResponse {

    void write(TerminalContext terminalContext);
}
