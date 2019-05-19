package com.soft1841.io;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 * 图片窗体程序
 *
 */
public class ImageFrame extends JFrame {
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private Icon icon;
    public ImageFrame() throws IOException {
        init();
        setTitle("图片窗体");
        setSize(1000,600);
        //窗体自动居中
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    //设置布局，放置组件
    public void init() throws IOException {
       topPanel = new JPanel();
       buttons = new JButton[5];
       for (int i = 0; i<5;i++){
         buttons[i] = new JButton("按钮" + i + 1);
         topPanel.add(buttons[i]);
       }
       add(topPanel, BorderLayout.NORTH);
       imgLabel = new JLabel("图片");
       //读入本地的图片到内存的字节数组
        File srcFile = new File("D:/bg.jpg");
        InputStream inputStream;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(srcFile);
            bytes = new byte[(int) srcFile.length()];
            inputStream.read(bytes);
        }catch (IOException e){
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        JLabel nameLabel = new JLabel("图片名称");
        LocalTime time = LocalTime.now();
        nameLabel.setText(srcFile.getAbsolutePath() + "       " + time);
        add(imgLabel,BorderLayout.CENTER);
        add(nameLabel,BorderLayout.SOUTH);
    }

    public static void main(String[] args) throws IOException {
       new ImageFrame();
    }
}
