package com.soft1841.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest1 {
    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("海明威","老人与海",66.0));
        bookList.add(new Book("玛格丽特","飘",88.0));
        bookList.add(new Book("塞林格","麦田里的守望者",55.0));

        System.out.println(bookList);
        bookList.add(2,new Book("Java","高数",44.0));
        System.out.println(bookList);
        bookList.remove(2);
        System.out.println(bookList);
        bookList.set(2,new Book("Java","高数",33.0));
        System.out.println(bookList);
        System.out.println(bookList.get(2));
        bookList.add(new Book("高数","Java",22.0));
        System.out.println(bookList.indexOf(new Book("Java","高数",33.0)));
        System.out.println(bookList.lastIndexOf(new Book("高数","Java",55.0)));

        System.out.println("------图书信息------");
        System.out.println("作者 书名 价格");
        for (int i = 0,length = bookList.size(); i < length ;i++){
            System.out.println(bookList.get(i).getId() +"" +bookList.get(i).getName() + "" + bookList.get(i).getPrice());
            System.out.println();
            }
        }
    }

