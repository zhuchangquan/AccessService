package com.example.server.impl;

import com.example.model.TerminalContext;
import com.example.server.GetParser;
import io.netty.handler.codec.http.HttpRequest;

public class GetRequestParser implements GetParser {
    @Override
    public void parserHeader(TerminalContext terminalContext, HttpRequest httpRequest) {

    }
}
