package com.soft1841.io;

import java.io.File;
import java.io.IOException;

public class DateTest {
    public static void main(String[] args) throws IOException {
       String path = "D:\\Test";
       File date = new File(path +"\\");
       if (!date.exists()){
           date.mkdirs();
       }
                File file = new File(path + "/" + "hello.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("文件创建成功！");
                }
            }
        }


