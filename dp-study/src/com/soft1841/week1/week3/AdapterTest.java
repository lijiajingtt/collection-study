package com.soft1841.week1.week3;
public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("特长生招募中....");
        Student student = new Student(){
            public void javaStudy(){
                System.out.println("我是一名Java大神");
            }
        };
        student.javaStudy();
        Student student1= new Student(){
            public void playBasketball(){
                System.out.print("我篮球打的好, ");
            }
            public void playFootball(){
                System.out.print("我还喜欢唱跳、rap");
            }
        };
        student1.playBasketball();
        student1.playFootball();
    }
}