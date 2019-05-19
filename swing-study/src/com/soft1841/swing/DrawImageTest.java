package com.soft1841.swing;

import javax.swing.*;
import java.awt.*;

public class DrawImageTest extends JFrame {
    public DrawImageTest(){
        this.setSize(500,380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        new DrawImageTest().setVisible(true);
    }

    class CanvasTest extends Canvas {
        public void paint(Graphics g){
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/img/bg.jpg")).getImage();
            g2.drawImage(img,0,0,this);
        }
    }
}

