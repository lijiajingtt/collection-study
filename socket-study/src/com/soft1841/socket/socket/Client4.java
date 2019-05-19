package com.soft1841.socket.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 服务器端向客户端发送信息——控制台
 * client端，通过BufferedReader读取文本内容
 */
public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",10086);
        System.out.println("成功连上服务器");
        //声明BufferedReader对象，通过客户端的输入流接收信息
        BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = buf.readLine();
        System.out.println("服务器端输出内容："+str);
        buf.close();
        client.close();
    }
}

