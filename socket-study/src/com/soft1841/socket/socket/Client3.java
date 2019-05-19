package com.soft1841.socket.socket;

import java.io.IOException;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10086);
        System.out.println(socket.getInetAddress() + "成功连接服务器...");
    }
}
