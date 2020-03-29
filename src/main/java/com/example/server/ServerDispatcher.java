package com.example.server;

import com.example.model.TerminalContext;
import com.example.model.TerminalRequestData;

/**
 * 端测约定好的body体的内容既包含json数据，又包含语音数据
 * application/json
 * application/octet-stream
 */
public interface ServerDispatcher {

    /**
     * 处理json数据，按照事件进行分发
     */
    void dispatchEvent(TerminalContext terminalContext,TerminalRequestData terminalRequestData);

    /**
     * @param bytes 语音数据
     */
    void dispatchOctetStream(byte[] bytes);
}
