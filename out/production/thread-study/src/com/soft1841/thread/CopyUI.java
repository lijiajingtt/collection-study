package com.soft1841.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CopyUI extends JFrame implements ActionListener{

    private static final long serialVersionUID = 5521199214537722822L;
    private JTextField textSrc;
    private JTextField textAim;
    private JTextField textNumberThread;
    private JButton buttonStart;
    private JButton buttonSrc;
    private JButton buttonAim;
    public JProgressBar bar;

    public static void main(String[] args) {
        CopyUI copyui = new CopyUI();
    }

    public CopyUI() {
        init();
    }

    private void init() {
        this.setTitle("多文件复制");
        this.setBounds(270, 80, 800, 600);
        this.setLayout(null);

        Font fontText = new Font("宋体", Font.ITALIC, 20);
        Font fontLab = new Font("宋体", Font.BOLD, 27);


        JLabel labSrcPath = new JLabel("源文件");
        labSrcPath.setFont(fontLab);
        labSrcPath.setBounds(30, 30, 100, 60);

        textSrc = new JTextField();
        textSrc.setFont(fontText);
        textSrc.setBounds(150, 30, 400, 60);

        buttonSrc = new JButton("打开源文件路径");
        buttonSrc.setBounds(580, 40, 150, 40);
        buttonSrc.addActionListener(this);

        this.add(labSrcPath);
        this.add(textSrc);
        this.add(buttonSrc);


        JLabel labAimPath = new JLabel("目标路径");
        labAimPath.setFont(fontLab);
        labAimPath.setBounds(20, 130, 150, 60);

        textAim = new JTextField();
        textAim.setFont(fontText);
        textAim.setBounds(150, 130, 400, 60);

        buttonAim = new JButton("打开目标文件路径");
        buttonAim.setBounds(580, 140, 150, 40);
        buttonAim.addActionListener(this);

        this.add(labAimPath);
        this.add(textAim);
        this.add(buttonAim);


        JLabel labNumberThread = new JLabel("线程数量");
        labNumberThread.setFont(fontLab);
        labNumberThread.setBounds(20, 230, 150, 60);

        textNumberThread = new JTextField();
        textNumberThread.setBounds(150, 230, 400, 60);

        buttonStart = new JButton("开始");
        buttonStart.setBounds(100, 350, 100, 40);
        buttonStart.addActionListener(this);

        this.add(labNumberThread);
        this.add(textNumberThread);
        this.add(buttonStart);


        //添加窗口事件处理程序，使用适配器，监听窗口关闭事件，使得关闭的同时结束程序
        //点击右上角的关闭按钮默认不会结束程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭窗口");
                System.exit(-1);
            }
        });

        bar = new JProgressBar();
        bar.setBounds(50, 420, 700, 50);
        this.add(bar);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonStart) {
            System.out.println("点击开始按钮");
            String srcPath = textSrc.getText();
            String aimPath = textAim.getText();
            int count = Integer.parseInt(textNumberThread.getText());
            System.out.println("源文件路径：" + srcPath + ", 目标文件路径：" + aimPath + ", 线程数：" + count);

            Copier copier = new Copier(this, srcPath, aimPath, count);
            copier.startCopy();

        }else if(e.getSource() == buttonSrc){
            System.out.println("打开源文件路径");
            FileDialog dialog = new FileDialog(this, "源文件路径", FileDialog.LOAD);
            dialog.setVisible(true);
            String srcPath = dialog.getDirectory() + dialog.getFile();
            if(srcPath == "nullnull") {
                textSrc.setText("");
            }else {
                textSrc.setText(srcPath);
            }
            System.out.println(srcPath);
        }else if(e.getSource() == buttonAim){
            System.out.println("打开目标文件路径");
            FileDialog dialog = new FileDialog(this, "目标文件路径", FileDialog.LOAD);
            dialog.setVisible(true);
            String aimPath = dialog.getDirectory() + dialog.getFile();
            if(aimPath == "nullnull") {
                textAim.setText("");
            }else {
                textAim.setText(aimPath);
            }
            System.out.println(aimPath);
        }
    }
}