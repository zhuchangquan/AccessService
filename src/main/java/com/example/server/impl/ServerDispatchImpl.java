package com.example.server.impl;

import com.example.business.XunfeiRequestHandler;
import com.example.model.TerminalContext;
import com.example.model.TerminalRequestData;
import com.example.server.ServerDispatcher;
import com.example.task.XunfeiRequestRunnable;
import com.example.thread.XunFeiThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServerDispatchImpl implements ServerDispatcher {

    @Autowired
    XunFeiThreadPoolExecutor xunFeiThreadPoolExecutor;

    @Autowired
    XunfeiRequestHandler xunfeiRequestHandler;

    @Override
    public void dispatchEvent(TerminalContext terminalContext,TerminalRequestData terminalRequestData) {
        xunFeiThreadPoolExecutor.execute(new XunfeiRequestRunnable(terminalContext,terminalRequestData, xunfeiRequestHandler));
    }

    @Override
    public void dispatchOctetStream(byte[] bytes) {

    }
}
