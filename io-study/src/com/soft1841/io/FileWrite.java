package com.soft1841.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWrite {
    public void fileWrite() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一些东西：");
        String string = scanner.next();
        File file = new File("D://","Example.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(string);
        fileWriter.close();
    }
    public static void main(String[] args) throws IOException{
        FileWrite fWrite = new FileWrite();
        fWrite.fileWrite();
    }
}