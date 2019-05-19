package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        System.out.println(set);
        for (int i = 0 ,len = set.size();i < len;i++){
            System.out.println(set);
        }

        String s1 = new String("A");
        String s2 = new String("B");
        String s3 = new String("C");
        String s4 = new String("A");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            iterator.next();
            System.out.println(iterator.next());

            set.forEach(s -> System.out.println(s));
        }
    }
}
