package com.soft1841.week1.week4;

public class Proxy implements Subject {

    @Override
    public void buyMac() {
        RealSunject realSunject = new RealSunject();
        realSunject.buyMac();
        this.wrapMac();
    }
    public void wrapMac(){
        System.out.println("用盒子包装好Mac");
    }
}