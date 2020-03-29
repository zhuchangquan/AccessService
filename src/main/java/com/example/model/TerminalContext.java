package com.example.model;

import io.netty.channel.Channel;
import lombok.Data;


/**
 * 终端上下文对象，用于保存端侧的http请求相关信息,
 */
@Data
public class TerminalContext {

    /**
     * netty针对每一个http请求生成的连接对象
     */
    Channel channel;

    /**
     * 请求类型
     */
    String methodName;

    /**
     * 远程连接ip地址
     */
    String remoteAdress;

    /**
     * 是否已经给端测响应
     */
    Boolean isAreadyWriteAndFlush;

}
