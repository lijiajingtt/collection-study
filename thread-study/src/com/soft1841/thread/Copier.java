package com.soft1841.thread;

import javax.swing.*;
import java.io.File;
import java.io.RandomAccessFile;

public class Copier {
    private CopyUI copyui;
    private String srcPath;
    private String aimPath;
    private int count;

    public Copier(CopyUI copyui, String srcPath, String aimPath, int count) {
        this.copyui = copyui;
        this.srcPath = srcPath;
        this.aimPath = aimPath;
        this.count = count;
    }

    public void startCopy() {
        File file = new File(srcPath);
        int fileSize = (int) file.length();
        System.out.println("文件大小" + fileSize);

        copyui.bar.setMaximum(fileSize);

        int average = fileSize/count;
        int size = 0;

        for(int i=0; i<count; i++) {
            if(i == count-1) {
                size = fileSize-i*average;
            }else {
                size = average;
            }

            //动态添加bar
            JProgressBar bar = new JProgressBar();
            bar.setBounds(50, 480+i*30, 700, 20);
            copyui.add(bar);
            MyThread t = new MyThread(copyui, bar, srcPath, aimPath, average*i, size);

            t.start();
        }
        System.out.println("所有线程分配结束");
    }
}

class MyThread extends Thread {
    private CopyUI copyui;     // 所有线程的总进度条
    private JProgressBar bar;  // 线程各自对应的进度条
    private String srcPath;
    private String aimPath;
    private int start; // 开始写入位置
    private int size;  // 负责写入的量

    public MyThread(CopyUI copyui,JProgressBar bar, String srcPath, String aimPath, int start, int size) {
        this.copyui = copyui;
        this.bar = bar;
        this.srcPath = srcPath;
        this.aimPath = aimPath;
        this.start = start;
        this.size = size;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始位置：" + start + "，写入量：" + size);
        RandomAccessFile rafSrc = null;
        RandomAccessFile rafAim = null;
        try {
            rafSrc = new RandomAccessFile(srcPath, "r");
            rafAim = new RandomAccessFile(aimPath, "rw");

            rafSrc.seek(start);
            rafAim.seek(start);

            int len = -1;
            byte[] buffer = new byte[1024];
            int number = size;
            bar.setMaximum(size);
            while((len = rafSrc.read(buffer)) != -1) {
                rafAim.write(buffer, 0, len);
                number = number - 1024;

                bar.setValue(bar.getValue()+1024);  // 设置线程自己的进度条

                synchronized (copyui) {     // 设置所有线程共用的进度条
                    int value = copyui.bar.getValue();
                    copyui.bar.setValue(value + 1024);
                }

                if(number < 1024 && number > 0) {
                    len = rafSrc.read(buffer);
                    rafAim.write(buffer, 0, number);

                    bar.setValue(bar.getValue()+number);

                    synchronized (copyui) {
                        int value = copyui.bar.getValue();
                        copyui.bar.setValue(value + number);
                    }
                    System.out.println(Thread.currentThread().getName() + "开始位置：" + start + "，写入" + size + "完毕");
                    break;
                }
//              System.out.println("number = " + number + ", size = " + size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rafSrc != null) {
                    rafSrc.close();
                }
                if(rafAim != null) {
                    rafAim.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println("已关闭文件流");
        }
    }
}