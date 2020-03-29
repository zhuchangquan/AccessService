package com.example.server.impl;

import com.example.handler.HttpProcessor;
import com.example.model.TerminalContext;
import com.example.model.TerminalRequestData;
import com.example.server.PostParser;
import com.example.server.ServerDispatcher;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.HttpPostMultipartRequestDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 用来处理http请求中是multipart/form-data类型的数据
 */
@Component
public class MultiPartBodyParser implements PostParser {

    @Autowired
    ServerDispatcher serverDispatcher;

    @Autowired
    HttpProcessor httpProcessor;

    // netty提供的对MultipartBody进行解析的一个解析器，用完需要关闭
    HttpPostMultipartRequestDecoder decoder;

    @Override
    public void init(HttpRequest httpRequest) {

        decoder = new HttpPostMultipartRequestDecoder(httpRequest);
    }

    @Override
    public void parserBody(TerminalContext terminalContext, HttpContent httpContent) {
        if (decoder.hasNext()){

            // 处理json数据
            handJsonPart(terminalContext, httpContent);

            // 处理语音数据
            HandAudioPart(terminalContext, httpContent);

        }
    }

    private void HandAudioPart(TerminalContext terminalContext, HttpContent httpContent) {
        // byte[] 从netty组件httpContent中获取
        serverDispatcher.dispatchOctetStream(new byte[0]);
    }

    private void handJsonPart(TerminalContext terminalContext, HttpContent httpContent) {

        // byte[] 从netty组件httpContent中获取
        TerminalRequestData terminalRequestData = httpProcessor.generateTerminalRequestData(new byte[0]);
        serverDispatcher.dispatchEvent(terminalContext, terminalRequestData);

    }

    @Override
    public void release() {

    }
}
