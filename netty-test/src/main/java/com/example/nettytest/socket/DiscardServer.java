package com.example.nettytest.socket;

import com.example.nettytest.socket.ChildChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Package: com.example.nettytest
 * @ClassName: DiscardServer
 * @Author: yinj
 * @CreateTime: 2021/1/6 15:33
 * @Description: TODO
 */

    @Component
    public class DiscardServer {
        @Resource
        private ChildChannelHandler childChannelHandler;
        public void run(int port) throws Exception {
            EventLoopGroup bossGroup = new NioEventLoopGroup();
            EventLoopGroup workerGroup = new NioEventLoopGroup();
            System.out.println("准备运行端口：" + port);
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .option(ChannelOption.SO_BACKLOG, 128)
                        .childHandler(childChannelHandler);
                //绑定端口，同步等待成功
                ChannelFuture f = bootstrap.bind(port).sync();
                //等待服务监听端口关闭
                f.channel().closeFuture().sync();
            } finally {
                //退出，释放线程资源
                workerGroup.shutdownGracefully();
                bossGroup.shutdownGracefully();
            }
        }
}
