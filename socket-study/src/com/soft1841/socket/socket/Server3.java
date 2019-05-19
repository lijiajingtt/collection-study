package com.soft1841.socket.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动成功");
        while (true){
            Socket socket = ss.accept();
            ServerThread serverThread = new ServerThread();
            serverThread.setSocket(socket);
            Thread thread = new Thread(serverThread);
            thread.start();
        }
    }
}
class ServerThread implements Runnable{
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        System.out.println(socket.getInetAddress() + "客户端连接成功");
    }
}
