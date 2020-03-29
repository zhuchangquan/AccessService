package com.example.listener;

import com.example.model.TerminalContext;
import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class DefaultFutureListener implements GenericFutureListener {
    TerminalContext terminalContext;
    public DefaultFutureListener(TerminalContext terminalContext) {
        this.terminalContext = terminalContext;
    }

    @Override
    public void operationComplete(Future future) throws Exception {
        if(future.isDone()) {
            Channel channel = terminalContext.getChannel();
            log.info(terminalContext.getMethodName() + "of Response Success");
            channel.close();
        }
    }
}
