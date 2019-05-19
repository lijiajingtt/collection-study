package com.soft1841.socket.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class  Client1 extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton startBtn;
    private JButton confirmBtn;
    private JPanel topPanel;
    private Socket socket;
    private String info;
    public static void main(String[] args) {
        new Client1();
    }

    public Client1()  {
        init();
        setLocationRelativeTo(null);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {


        topPanel = new JPanel();
        confirmBtn = new JButton("发送");
        confirmBtn.setPreferredSize(new Dimension(120, 40));
        confirmBtn.addActionListener(this);
        textField = new JTextField();

        textField.setPreferredSize(new Dimension(300, 40));
        topPanel.add(textField);
        topPanel.add(confirmBtn);
        add(topPanel, BorderLayout.NORTH);
        textArea = new JTextArea();

        //文本域设置成不可编辑
        textArea.setEditable(false);
        //文本域设置成不可获得焦点
        textArea.setFocusable(false);
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane,BorderLayout.CENTER);
        startBtn = new JButton("启动客户端");
        add(startBtn, BorderLayout.SOUTH);
        startBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            try {
                startClient();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == confirmBtn) {
            OutputStream out = null;
            try {
                info="位哲武："+textField.getText();
                out = socket.getOutputStream();
                out.write(info.getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    private void startClient() throws IOException {
        socket = new Socket("192.168.43.89",10086);
        read();
    }
    private void read(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream in = null;
                try {
                    while (true){
                        in = socket.getInputStream();
                        byte[] a = new byte[1024];
                        in.read(a);
                        textArea.append(new String(a)+"\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
