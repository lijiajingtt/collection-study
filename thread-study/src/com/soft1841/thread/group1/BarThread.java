package com.soft1841.thread.group1;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BarThread extends Thread {
    private int[] num = {1,10,20,30,40,50,60,70,80,90,100};
    private JProgressBar bar;
    private JButton button;

    public BarThread(JProgressBar progressBar, JButton button) {
        this.bar = progressBar;
        this.button = button;
    }
    public void run() {
        bar.setStringPainted(true);
        bar.setIndeterminate(false);//采用确定的进度条样式
        for(int i = 0; i < num.length; i++) {
            try {
                bar.setValue(num[i]);
                Thread.sleep(100);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

