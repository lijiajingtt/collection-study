package com.soft1841.thread.timer;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerFrame extends JFrame {
    private JPanel typePanel;
    private JTextArea textArea;
    private TimerTask drawTask, typeTask, clockTask;
    private Timer timer;
    int x = 200;
    int y = 300;
    int width = 50;
    int height = 50;

    public TimerFrame() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Timer定时器练习");
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(97, 174, 239));
        g.drawOval(x, y, width, height);
    }

    private void init() throws IOException {
        typePanel = new JPanel();
        typePanel.setPreferredSize(new Dimension(800, 600));
        typePanel.setLayout(new BorderLayout());
        add(typePanel, BorderLayout.EAST);
        textArea = new JTextArea();
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        textArea.setFont(font);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        typePanel.add(textArea);

        drawTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
                x -= 25;
                y -= 25;
                width += 50;
                height += 50;
                if (x <= 0 || y <= 0) {
                    //取消定时任务
                    cancel();
                }
            }
        };
        File file = new File("D:\\out.txt");
        Reader reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        typeTask = new TimerTask() {
            int i = 0;
            int len = chars.length;

            @Override
            public void run() {
                char c = (char) chars[i];
                textArea.append(String.valueOf(c));
                i++;
                if (i == len - 1) {
                    cancel();
                }
            }
        };

        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                if(timeString.equals("2019-04-16 08:03:59")){
                    JOptionPane.showMessageDialog(null, "时间到~~");
                    drawTask.cancel();
                    typeTask.cancel();
                    this.cancel();
                }
            }
        };
        timer = new Timer();
        timer.schedule(drawTask, 0, 1000);
        timer.schedule(typeTask, 2000, 100);
        timer.scheduleAtFixedRate(clockTask, 0, 1000);
    }

    public static void main(String[] args) {
        new TimerFrame();
    }
}
