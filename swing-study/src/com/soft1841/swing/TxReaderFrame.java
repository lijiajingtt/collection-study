package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

 public class TxReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmButton;
    private JPanel topPanel;
    //内容多行文本域
    private JTextArea contentArea;
    private JLabel imageLabel;
    private  Icon icon;
    public TxReaderFrame(){
        init();
        setTitle("文本阅读窗体");
        setLocationRelativeTo(null);
        setSize(640,480);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init (){
//        Font font = new Font("微软雅黑",Font.PLAIN,26);
//        inputField.setFont(font);
        inputField = new JTextField(20);
        //指定这个框的大小
        inputField.setPreferredSize(new Dimension(150,40));
        confirmButton = new JButton("确认");
        //指定按钮的大小
        confirmButton.setPreferredSize(new Dimension(100,40));
        topPanel = new JPanel();
        topPanel.add(inputField);
        topPanel.add(confirmButton);
        //给按钮注册监听事件  监听在本窗体发生作用
        confirmButton.addActionListener(this);
        add(topPanel, BorderLayout.NORTH);
        //中间的多行文本
//        contentArea = new JTextArea();
//        add(contentArea,BorderLayout.CENTER);
        //图片的加入
        imageLabel = new JLabel();
        add(imageLabel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new TxReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框的内容
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        InputStream in;
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            in.read(bytes);
            icon = new ImageIcon(bytes);
            imageLabel.setIcon(icon);

//            InputStream inputStream = new FileInputStream(file);
//            byte[] bytes = new byte[(int) file.length()];
            //读入内容 到字节数组
//            inputStream.read(bytes);
            //使用bytes构建一个输出字符串
//            String resultStr = new String(bytes);
//            contentArea.append(resultStr);
//            //追加一次回车换行
//            contentArea.append("\r\n");
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null,"IO操作异常");
        }
    }
}
