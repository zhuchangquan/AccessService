package com.example.business;

import com.example.handler.ProxyHttpResponse;
import com.example.model.TerminalContext;
import com.example.model.TerminalRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 对接讯飞接口的处理类，采用webSocket协议进行对接,也可以对接http协议的接口
 * 可以采用websocket-client、okhttp等类库进行对接
 */
@Component
public class XunfeiRequestHandler {

    @Autowired
    ProxyHttpResponse proxyHttpResponse;

    public void webSocketRequest(TerminalContext terminalContext, TerminalRequestData terminalRequestData) {

        proxyHttpResponse.write(terminalContext);
    }
}
