package com.soft1841.io;

import java.io.*;
import java.util.UUID;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("D/bg.jpg");

        String srcFileName =  srcFile.getName();
        int position = srcFileName.indexOf(".");
        String suffixName = srcFileName.substring(position +1);
        String newName = UUID.randomUUID().toString();
        File endFile = new File("D:/" +"+newName+" +suffixName);

        //指定目标文件
        File destFile = new File("D/bg1.jpg");
        //创建一个字节数组，大小为源文件长度，长度转为int
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream inputStream = new FileInputStream(srcFile);
        //将源文件读入字节数组
        inputStream.read(bytes);
        //创建字节输出流
        OutputStream outputStream = new FileOutputStream(destFile);
        //将字节数组输出到目标文件
        outputStream.write(bytes);
        //关闭输入输出流
        inputStream.close();
        outputStream.close();
    }
}
