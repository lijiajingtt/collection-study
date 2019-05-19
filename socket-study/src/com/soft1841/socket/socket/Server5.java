package com.soft1841.socket.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5  {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器端口已启动，端口号10086");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread4 serverThread4 = new ServerThread4(socket);
            new Thread(serverThread4).start();
        }
    }
}
class ServerThread4 implements Runnable{

    private Socket socket;
    public ServerThread4(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功！");
        try {
            File file =new File("D:/bg.jpg");
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            OutputStream outputStream = socket.getOutputStream();
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            System.out.println("IO异常或打印异常");
        }
    }
}