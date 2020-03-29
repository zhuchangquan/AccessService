package com.example.handler.impl;


import com.example.handler.HttpProcessor;
import com.example.model.TerminalRequestData;
import org.springframework.stereotype.Component;


@Component
public class TerminalHttpProcessor implements HttpProcessor {


    @Override
    public TerminalRequestData generateTerminalRequestData(byte[] bytes) {
        return new TerminalRequestData();
    }
}
