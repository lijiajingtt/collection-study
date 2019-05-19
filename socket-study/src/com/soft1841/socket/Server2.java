package com.soft1841.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2  {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动");
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread1 server = new ServerThread1(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread1 implements Runnable{
    private  Socket socket;
    public ServerThread1(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功！");
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            BufferedReader br  = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(br.readLine());
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}