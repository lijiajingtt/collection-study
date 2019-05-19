package com.soft1841.gui;

import javax.swing.*;

public class CloudMusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 发现Button;
    private JButton MVButton;
    private JButton 朋友Button;
    private JPanel centerPanel;
    private JLabel bottom;
    private JPanel musicPanel;
    private JLabel music1;
    private JLabel music2;
    private JLabel music3;
    private JLabel music4;
    private JLabel music5;

    public static void main(String[] args) throws Exception{
        //根据系统设置swing的外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("CloudMusicFrame");
        frame.setContentPane(new CloudMusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置全屏
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.pack();
        frame.setVisible(true);
    }
}
