package com.soft1841.thread.group1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetThread extends Object implements Runnable{
    private String[] s = {"https://img.pc841.com/allimg/130327/1_130327175813_1.jpg",
            "https://img.pc841.com/allimg/130327/1_130327175741_1.jpg",
            "https://img.pc841.com/allimg/130327/1_130327175414_1.jpg",
            "https://img.pc841.com/allimg/130327/1_130327175235_1.jpg",
            "https://img.pc841.com/allimg/130327/1_130327175945_1.jpg",
            "https://img.pc841.com/allimg/130327/1_130327180050_1.jpg"};
    private JLabel jLabel;
    public void setjLabel(JLabel jLabel) {
        this.jLabel = jLabel;

    }
    @Override
    public void run() {
        int i = 0;
        int length = s.length;
        while (true) {
            try {
                URL url = new URL(s[i]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5 * 1000);
                InputStream inputStream = conn.getInputStream();
                ByteArrayOutputStream out1 = new ByteArrayOutputStream();
                //准备缓冲字节流数组
                byte[] buffer = new byte[1024];
                int len = 0;
                //每次读入一个缓冲区大小的字节数
                while ((len = inputStream.read(buffer)) != -1) {
                    //将缓冲区内容写出
                    out1.write(buffer, 0, len);
                }
                byte[] data = out1.toByteArray();
                inputStream.read(data);
                Icon icon = new ImageIcon(data);
                jLabel.setIcon(icon);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i == length){
                    i=0;
                }
            } catch (IOException e) {

            }
        }
    }
}
