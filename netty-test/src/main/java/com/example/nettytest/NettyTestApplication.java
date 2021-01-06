package com.example.nettytest;

import com.example.nettytest.socket.DiscardServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class NettyTestApplication implements CommandLineRunner {

    @Resource
    private DiscardServer discardServer;

    public static void main(String[] args) {
        SpringApplication.run(NettyTestApplication.class, args);
    }
    
    
    

    @Override
    public void run(String... args) throws Exception {
        discardServer.run(8080);
    }

}
