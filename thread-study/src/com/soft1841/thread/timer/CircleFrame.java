package com.soft1841.thread.timer;
import javax.swing.*;

public class CircleFrame extends JFrame {

    public CircleFrame() {
        init();
        setTitle("同心圆");
        setSize(1350, 1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        CircleThread circleThread = new CircleThread();
        circleThread.setFrame(this);
        new Thread(circleThread).start();
    }


    public static void main(String[] args) {
        new CircleFrame();
    }
}
