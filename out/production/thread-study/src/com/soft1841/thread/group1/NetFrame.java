package com.soft1841.thread.group1;


import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.*;

public class NetFrame extends JFrame implements ActionListener {
    private Box box = Box.createVerticalBox();
    private JLabel jLabel;
    private JLabel wordLabel;
    private JProgressBar progressBar = new JProgressBar();
    private JButton musicBtn;

    public NetFrame() {
        progressBar.setIndeterminate(true);
        progressBar.setStringPainted(true);
        progressBar.setString("图片正在加载");
        box.add(progressBar);
        add(box, BorderLayout.SOUTH);


        init();
        setTitle("轮播窗体");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init() {
        Font font = new Font("微软雅黑", Font.PLAIN, 30);
        jLabel = new JLabel();
        add(jLabel, BorderLayout.CENTER);
        NetThread nt = new NetThread();
        nt.setjLabel(jLabel);
        new Thread(nt).start();
        //wordLabel
        wordLabel = new JLabel();
        wordLabel.setFont(font);
        add(wordLabel, BorderLayout.NORTH);
        WordThread wt = new WordThread();
        wt.setWordLabel(wordLabel);
        new Thread(wt).start();
        //musicBtn
        musicBtn = new JButton("音乐欣赏");
        musicBtn.addActionListener(this);
        add(musicBtn, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == musicBtn) {
            RandomPointThread rt = new RandomPointThread();
            new Thread(rt).start();
        }
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new NetFrame();
    }
}
