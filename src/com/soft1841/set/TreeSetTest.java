package com.soft1841.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //集合中的基本类型为包装类，TreeSet是有序的
        Set<Integer> set = new TreeSet<>();
        set.add(-5);
        set.add(-7);
        set.add(10);
        set.add(6);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        System.out.println("Set集合中的元素");
        while (iterator.hasNext()){
            System.out.println(iterator.next() +"");
        }
    }
}
