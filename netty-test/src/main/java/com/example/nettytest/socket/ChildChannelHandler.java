package com.example.nettytest.socket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Package: com.example.nettytest
 * @ClassName: ChildChannelHandler
 * @Author: yinj
 * @CreateTime: 2021/1/6 15:34
 * @Description: TODO
 */
    @Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Resource
        private DiscardServerHandler discardServerHandler;

        @Override
        public void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(discardServerHandler);
        }
}
