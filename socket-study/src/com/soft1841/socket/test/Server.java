package com.soft1841.socket.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端窗体类
 *
 * @author
 *
 */
public class Server extends JFrame {

    private static final long serialVersionUID = 6206072788856936392L;

    private JTextArea info; // 显示消息的文本区
    private Socket socket; // 客户端Socket对象

    public Server(String title) {
        super(title); // 标题

        setSize(200, 300); // 窗体大小
        setLocation(200, 300); // 窗体坐标
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 默认关闭操作

        info = new JTextArea(); // 创建文本区对象
        info.setEditable(false); // 文本区不可编辑
        info.setFocusable(false); // 文本区不可获得焦点
        JScrollPane jsp = new JScrollPane(info); // 创建滚动面板
        this.add(jsp, BorderLayout.CENTER); // 将滚动面板添加到窗体中

        JPanel pnl = new JPanel(new BorderLayout()); // 创建面板
        final JTextField msg = new JTextField(); // 创建输入文本框
        JButton send = new JButton("发送"); // 创建发送按钮
        pnl.add(msg, BorderLayout.CENTER); // 将输入文本框添加到面板
        pnl.add(send, BorderLayout.EAST); // 将发送按钮添加到面板
        this.add(pnl, BorderLayout.SOUTH); // 将面板添加到窗体中

        setVisible(true); // 设置窗体可见

        startServer(); // 启动服务器

        // 注册“发送”按钮的事件监听器
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 创建缓冲区字节输出流对象
                    BufferedOutputStream out = new BufferedOutputStream(socket
                            .getOutputStream());
                    // 写入输出流
                    out.write((msg.getText() + "\n").getBytes());
                    // 刷出到客户端
                    out.flush();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    /**
     * 启动服务器
     */
    private void startServer() {
        try {
            // 创建ServerSocket对象，指定监听的端口
            ServerSocket server = new ServerSocket(30000);
            // 等待客户端连接
            socket = server.accept();
            // 读客户端发送消息
            read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 读客户端消息
     */
    private void read() {
        try {
            // 创建缓冲区字符输入流
            final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            // 开启新线程用于专门读数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    char[] ch = new char[1024];
                    // 读输入流中的数据
                    while (true) {
                        int len;
                        try {
                            len = reader.read(ch);
                            info.append(new String(ch, 0, len)); // 追加到文本区显示
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new Server("服务器");
    }
}