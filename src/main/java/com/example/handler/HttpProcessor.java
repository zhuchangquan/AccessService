package com.example.handler;

import com.example.model.TerminalRequestData;

/**
 * 生成终端请求数据
 */
public interface HttpProcessor {

    TerminalRequestData generateTerminalRequestData(byte[] bytes);
}
