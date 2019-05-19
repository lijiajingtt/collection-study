package com.soft1841.swing;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread extends Thread {
    private JLabel timeLabel;
    public void setTimeLabel(JLabel timeLabel){
        this.timeLabel=timeLabel;
    }
    @Override
    public void run(){
        while (true){
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            Date currentTime = new Date();
            String a = format.format(currentTime);
            timeLabel.setText(a);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
