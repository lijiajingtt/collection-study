package com.soft1841.socket.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动：");
        Socket socket;
        while (true){
            socket = serverSocket.accept();
            ServerThread2 server = new ServerThread2(socket);
            new Thread(server).start();
        }
    }
}
class ServerThread2 implements Runnable{
    private Socket socket;

    public ServerThread2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"连接成功");
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            File file = new File(System.getProperty("user.dir")+ UUID.randomUUID().toString()+".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] date = new byte[1024];
            int tmp;
            while ((tmp = bis.read(date))!=-1){
                bos.write(date,0,tmp);
            }
            bos.close();
            bis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}