package com.soft1841.week1;

//单例模式测试程序
public class SingLetonTest {
    public static void main(String[] args) {
        //通过类方法获得唯一可用对象
        SingLeton object = SingLeton.getInstance();
        //显示消息
        object.showMessage();
    }
}