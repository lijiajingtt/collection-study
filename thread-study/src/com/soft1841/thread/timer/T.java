package com.soft1841.thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;/**
 * Timer测试
 */
public class T {

    public static void main(String[] args){
        f1();
    }


    /**
     * Timer类的schedule和scheduleAtFixedRate
     * 方法测试
     */
    public static void f1(){
        BTask task = new BTask();
        Date date = new Date();
        long now = System.currentTimeMillis();
        date.setTime(now-1);
        System.out.println("now:"+now);

        //如果时间date是一个过期的时间,那么schedule会立即执行一次，
        //然后每隔一段时间执行一次
        //new Timer().schedule(task,date,2000);

        //实测scheduleAtFixedRate和schedule效果一样
        new Timer().scheduleAtFixedRate(task,date,2000);
    }



    /**
     * 1个Timer只开启一个线程且一个任务只能被一个Timer执行<br/>
     * 如果需要多个线程执行多个任务那么就多new几个Timer<br/>
     * 多new几个TimerTask让Timer来执行
     */
    public static void f2(){
        TimerTask t1 = new ATask(3);
        TimerTask t2 = new ATask(3);
        new Timer().schedule(t1,0,2000);
        new Timer().schedule(t2,0,2500);
    }

    /**
     * 使用Schedule线程池可以让多个线程执行同一个任务<br/>
     * ScheduledExecutorService延迟任务的执行
     */
    public static void f3(){
        //这时启动了两个线程区执行这项任务
        TimerTask t1 = new ATask(3);
        ScheduledExecutorService se = Executors.newScheduledThreadPool(2);
        se.schedule(t1,2,TimeUnit.SECONDS);
        se.schedule(t1,1,TimeUnit.SECONDS);
        se.shutdown();

    }
}
class ATask extends TimerTask{
    private static long START = System.currentTimeMillis();
    private int N;

    public ATask(int N){
        this.N=N;
    }

    @Override
    public void run(){
        long s = System.currentTimeMillis()-START;
        System.out.println(Thread.currentThread().getName()+" 开始:"+s);
        try {
            TimeUnit.SECONDS.sleep(N);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        long e = System.currentTimeMillis()-START;
        System.out.println(Thread.currentThread().getName()+" 结束:"+e);
    }
}
class BTask extends TimerTask{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+System.currentTimeMillis());
    }
}
