package com.soft1841.thread;

public class JoinDemo extends Thread {
    @Override
    public void run() {
        System.out.println("节目开始");
    }
    public static void main(String[] args) throws InterruptedException {
        JoinDemo joinDemo = new JoinDemo();
        //新生状态
        Thread thread = new Thread(joinDemo);
        //CPU调度运行
        System.out.println("开始倒数");
        for (int i = 10; i>=1;i--){
            Thread.sleep(1000);
            System.out.println(i);
            if (i ==1){
                //main阻塞,thread加入
                thread.start();
                thread.join();
            }
        }
    }
}

