package com.soft1841.thread.group1;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        //创建客户端对象，指定连接的服务器IP和端口
        Socket socket = new Socket("10.40.201.61",10086);
        System.out.println("已和服务器建立连接，远程主机地址：" + socket.getRemoteSocketAddress());
    }
}
