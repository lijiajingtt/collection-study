package com.soft1841.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.236.204",10086);
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        in.read(b);
        System.out.println("服务端发送的数据是：" + new String(b));
        in.close();
        socket.close();
    }
}
