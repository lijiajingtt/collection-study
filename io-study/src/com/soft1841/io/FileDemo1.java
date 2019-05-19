package com.soft1841.io;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/README.md");
        //判定如果file不存在，则创建新文件
        if (!file.exists()){
            file.createNewFile();
        }
    }
}
