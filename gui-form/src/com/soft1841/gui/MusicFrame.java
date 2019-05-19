package com.soft1841.gui;

import javax.swing.*;

public class MusicFrame {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JButton 我喜欢Button;
    private JButton 本地和下载Button;
    private JButton 播放历史Button;
    private JButton 试听列表Button;
    private JPanel centerPanel;
    private JPanel songsheetPanel;
    private JPanel rightPanel;

    public static void main(String[] args) throws Exception {
        //根据系统设置swing的外观
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("MusicFrame");
        frame.setContentPane(new MusicFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        frame.pack();
        frame.setVisible(true);
    }
}
