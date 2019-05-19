package com.soft1841.thread.group1;
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RandomPointThread extends Thread {
    @Override
    public void run() {

        try {
            URL url = new URL("https://y.qq.com/portal/player.html");
            AudioClip audioClip = Applet.newAudioClip(url);
            audioClip.play();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
