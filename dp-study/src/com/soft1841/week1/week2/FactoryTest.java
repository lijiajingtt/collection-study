package com.soft1841.week1.week2;

public class FactoryTest {
    public static void main(String[] args) {
        Shape cricle = ShapeFactory.getCircleInstance();
        cricle.draw();

        Shape rectangle = ShapeFactory.getRectangleIstance();
        rectangle.draw();
    }
}