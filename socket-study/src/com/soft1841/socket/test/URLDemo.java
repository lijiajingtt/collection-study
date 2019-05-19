package com.soft1841.socket.test;
import java.io.IOException;
import java.net.URL;

/**
 * URL实例
 * @author 李家劲
 * 2018.5.14
 */
public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.runoob.com/java/java-tutorial.html");
            System.out.println("URL为："+url.toString());
            System.out.println("协议为："+url.getProtocol());
            System.out.println("验证消息："+ url.getAuthority());
            System.out.println("文件名及请求参数："+url.getFile());
            System.out.println("主机名："+url.getHost());
            System.out.println("路径："+url.getPath());
            System.out.println("端口："+url.getPort());
            System.out.println("默认端口："+url.getDefaultPort());
            System.out.println("请求参数："+url.getQuery());
            System.out.println("定位位置："+url.getRef());
        }catch (IOException e){

        }

    }
}