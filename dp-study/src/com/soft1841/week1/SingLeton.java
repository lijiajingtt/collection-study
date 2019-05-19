package com.soft1841.week1;

public class SingLeton {
    private static SingLeton instance = new SingLeton();
    private SingLeton(){

    }
    public  static SingLeton getInstance(){
        return instance;
    }
    public void showMessage(){
        System.out.println("Hello World!");
    }

}