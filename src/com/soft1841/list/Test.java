package com.soft1841.list;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //1、录入商品信息（map集合）
        map.put(1, 66);
        map.put(2, 83);
        map.put(3, 72);
        map.put(4, 96);
        map.put(5, 51);
        map.put(6, 94);
        //2、遍历输出所有商品信息（map集合调动entry方法后利用增强for遍历输出）
        Set<Map.Entry<Integer, Integer>> ent = map.entrySet();
        System.out.println("商品：\t\t编号");
        for(Map.Entry<Integer, Integer> e:ent) {
            //存编号
            list.add(e.getValue());
            //输出所有商品的编号（按录入顺序输出，未排序）
            System.out.println(e.getKey()+"\t\t"+e.getValue());
        }
        //3、输出商品销售前三种的商品信息，集合的工具类进行排序
        Collections.sort(list);
        System.out.println("前三种商品的编号如下：");
        //输出商品销售前三种的编号（成绩由高到低的输出）
        for(int i=1;i<=3;i++) {//只输出三种商品信息
            //System.out.println(list.get(list.size()-i));
            for(Map.Entry<Integer, Integer> e:ent) {//遍历map集合
                if(list.get(list.size()-i)==e.getValue()) {//获取前三种的商品编号
                    //存编号，为第二问做铺垫
                    set.add(e.getKey());
                    //这里的输出语句在前三种无重复时可用
                    System.out.println(e.getKey()+"\t\t"+e.getValue());
                }
            }
        }
    }
}

