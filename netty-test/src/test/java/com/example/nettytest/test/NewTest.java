package com.example.nettytest.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @Package: com.example.nettytest
 * @ClassName: NewTest
 * @Author: yinj
 * @CreateTime: 2021/1/6 15:40
 * @Description: TODO
 */
public class NewTest {

    public static void main(String[] args){
        try {
            Socket socket=new Socket("localhost",8080);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.write("===这是传输的内容123456===" + new Date());
            printWriter.flush();
            socket.shutdownOutput();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
