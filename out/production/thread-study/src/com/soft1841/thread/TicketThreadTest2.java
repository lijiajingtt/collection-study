package com.soft1841.thread;

/**
 * 售票线程程序2
 * 实现Runnable接口的方式实现
 *
 */
public class TicketThreadTest2 {
    public static void main(String[] args) {
        TicketThread2 tt = new TicketThread2();
        Thread thread1 = new Thread(tt);
        thread1.start();
        TicketThread2 tt1 = new TicketThread2();
        Thread thread2 = new Thread(tt1);
        thread2.start();
        TicketThread2 tt2 = new TicketThread2();
        Thread thread3 = new Thread(tt2);
        thread3.start();
    }

}
class TicketThread2 implements Runnable{
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0 ){
            System.out.println(Thread.currentThread().getName() +"售票，当前票数" +--tickets);
        }
    }
}
