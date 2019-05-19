package com.soft1841.thread.timer;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MultiCircle extends JPanel {
    private BufferedImage bi = new BufferedImage(320, 240,
            BufferedImage.TYPE_INT_BGR);

    public MultiCircle() {
        setPreferredSize(new Dimension(320, 240));
    }

    public void paintComponent(Graphics g) {
        int radius = 50;
        g.setColor(Color.red);
        for (int i = 1; i <= 5; i++) {
            g.drawOval(150 - (radius + 10 * i), 150 - (radius + 10 * i),
                    (radius + 10 * i) * 2, (radius + 10 * i) * 2);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MultiCircle");
        frame.add(new MultiCircle());
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}