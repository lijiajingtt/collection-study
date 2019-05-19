package com.soft1841.thread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame implements ActionListener{
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
    private JTextArea textArea;
    private JButton buttonSaveOther;
    private JButton buttonCancel;
    private JButton buttonSure;
    private File nowFile;
    private JMenuItem fileItem;

    public MainFrame() {
        initFrame();
        this.setVisible(true);
    }

    //界面布局
    public void initFrame() {
        //创建窗口
        this.setTitle("My title");
        //设置窗口大小，位置，左上角是原点
        this.setBounds(270, 80, 810, 640);

        //设置JFrame的布局为null
        this.setLayout(null);

        Font font = new Font("宋体", Font.BOLD, 27);

        textArea = new JTextArea();
        textArea.setFont(font);

        //滚动面板
        JScrollPane pane = new JScrollPane(textArea);
        pane.setBounds(30, 30, 750, 400);

        this.add(pane);

        buttonSaveOther = new JButton("另存为");
        //设置按钮的位置(相对于所在容器的)，大小
        buttonSaveOther.setBounds(75, 500, 120, 50);
        buttonSaveOther.addActionListener(this);
        this.add(buttonSaveOther);

        buttonSure = new JButton("保存");
        buttonSure.setBounds(345, 500, 120, 50);
        buttonSure.addActionListener(this);
        this.add(buttonSure);

        buttonCancel = new JButton("退出");
        buttonCancel.setBounds(615, 500, 120, 50);
        buttonCancel.addActionListener(this);
        this.add(buttonCancel);

        //添加窗口事件处理程序，使用适配器
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭窗口");
                System.exit(-1);
            }
        });

        //添加菜单栏
        JMenuBar menuBar = new JMenuBar();
        //添加菜单
        JMenu menu = new JMenu("文件");
        //添加菜单项
        fileItem = new JMenuItem("打开");
        fileItem.addActionListener(this);
        menu.add(fileItem);
        menu.addSeparator();
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    //绑定监听事件
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        FileWriter writer = null;
        FileReader reader = null;
        if(buttonSaveOther == event) {
            try {
                System.out.println("另存为按钮");
                FileDialog dialog = new FileDialog(this, "保存位置", FileDialog.SAVE);
                dialog.setVisible(true);
                nowFile = new File(dialog.getDirectory(), dialog.getFile());
                System.out.println(dialog.getFile());
                System.out.println(dialog.getDirectory());
                writer = new FileWriter(nowFile);
                writer.write(textArea.getText());

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println("关闭文件流");
            }
        }else if(buttonSure == event) {
            System.out.println("保存按钮");

            try {
                writer = new FileWriter(nowFile);
                writer.write(textArea.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if(writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println("关闭文件流");
            }

        }else if(buttonCancel == event) {
            System.out.println("退出按钮");
            this.dispose();
        }else if(fileItem == event) {
            System.out.println("打开文件按钮");
            try {
                FileDialog dialog = new FileDialog(this, "打开位置", FileDialog.LOAD);
                dialog.setVisible(true);
                nowFile = new File(dialog.getDirectory(), dialog.getFile());
                System.out.println(dialog.getFile());
                System.out.println(dialog.getDirectory());
                reader = new FileReader(nowFile);
                char[] c = new char[1024];
                int len = -1;
                String str = "";
                while((len = reader.read(c)) != -1) {
                    str = str + new String(c, 0, len);
                }
                textArea.setText(str);
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if(reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                System.out.println("关闭文件流");
            }
        }
    }
}