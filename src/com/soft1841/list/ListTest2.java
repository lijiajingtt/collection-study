package com.soft1841.list;

import java.util.*;

public class ListTest2 {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student(1, "张三"));
        list2.add(new Student(2, "李四"));
        Map<String, List<Student>> map = new HashMap<>();
        map.put("男神", list1);
        map.put("女神", list2);
        System.out.println(map);
        System.out.println("***************按性别输出集合的结果*****************");
        Iterator<Map.Entry<String, List<Student>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Student>> entry = iterator.next();
            List<Student> list = entry.getValue();
            for (Student s : list) {
                System.out.println("学号:" + s.getId() + ",姓名:" + s.getName());
                System.out.println();
            }
        }
    }
}
