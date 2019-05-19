package com.soft1841.io;

import java.io.*;

public class OutPutEx {
    public static void main(String[] args) throws IOException {
        String string = "I love Java";
        File file1 = new File("D:\\out.txt");
        if (!file1.exists()){
          file1.createNewFile();
        }
        OutputStream out = new FileOutputStream(file1);
        PrintStream printStream = new PrintStream(out);
        printStream.print(string);
        System.out.println(string);
        printStream.close();
    }
}
