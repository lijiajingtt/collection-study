package com.soft1841.swing;

import com.soft1841.io.NumThread;

import javax.swing.*;
import java.awt.*;


public class NumFrame extends JFrame {
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel movePane;
    public NumFrame(){
        init();
        setTitle("试验窗体");
        setSize(640,480);
        setLocationRelativeTo(null);
        //窗口大小不可变
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        java.awt.Font font = new java.awt.Font("微软雅黑", Font.BOLD,30);
        //numberLabel
        numberLabel = new JLabel();
        numberLabel.setFont(font);
        add(numberLabel,BorderLayout.NORTH);
        NumThread numThread = new NumThread();
        numThread.setNumberLabel(numberLabel);
        numThread.start();
        //timeLabel
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        add(timeLabel,BorderLayout.SOUTH);
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        //movePane
        movePane = new JPanel();
        add(movePane);
        RgbThread rgbThread = new RgbThread();
        rgbThread.setMovePane(movePane);
        rgbThread.start();

    }

    public static void main(String[] args) {
        new NumFrame();
    }
}

