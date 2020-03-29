package com.example.task;

import com.example.business.XunfeiRequestHandler;
import com.example.model.TerminalContext;
import com.example.model.TerminalRequestData;


public class XunfeiRequestRunnable implements Runnable {
    private TerminalContext terminalContext;

    private TerminalRequestData terminalRequestData;

    private XunfeiRequestHandler xunfeiRequestHandler;

    public XunfeiRequestRunnable(TerminalContext terminalContext, TerminalRequestData terminalRequestData,
                                    XunfeiRequestHandler xunfeiRequestHandler){
        this.terminalContext = terminalContext;
        this.terminalRequestData = terminalRequestData;
        this.xunfeiRequestHandler = xunfeiRequestHandler;
    }
    @Override
    public void run() {
        xunfeiRequestHandler.webSocketRequest(terminalContext, terminalRequestData);
    }
}
