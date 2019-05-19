package com.soft1841.io;

public class Main
{
    private static int num = 1;

    public static void main(String[] args)
    {
        Thread a = new Thread(new RandomRunnable("A"));
        Thread b = new Thread(new RandomRunnable("B"));
        Thread c = new Thread(new RandomRunnable("C"));
        Thread d = new Thread(new RandomRunnable("D"));
        Thread e = new Thread(new RandomRunnable("E"));
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    public static void add(String name)
    {
        synchronized (Main.class)
        {
            if (num < 101)
            {
                System.out.println("线程" + name + "随机数:"
                        + (1 + (int) (Math.random() * 1000) + " " + num));
                num++;
            }

        }
    }

    public static int getNum()
    {
        return num;
    }
}

class RandomRunnable implements Runnable
{
    private String name;

    public RandomRunnable(String name)
    {
        this.name = name;
    }

    public void run()
    {
        while(Main.getNum() < 101)
        {
            Main.add(name);
        }
    }
}