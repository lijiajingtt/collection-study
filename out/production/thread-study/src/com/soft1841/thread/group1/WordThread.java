package com.soft1841.thread.group1;

import javax.swing.*;
public class WordThread extends Thread {
    private JLabel wordLabel;
    private String[]word = {"时间是一切财富中最宝贵的财富。 ",
            "把时间用在思考上是最能节省时间的事情。",
            "真理惟一可靠的标准就是永远自相符合。 ",
            "生活有度，人生添寿。 —— 书摘",
            "从不浪费时间的人没有工夫抱怨时间不够。 ",
            "行万里路，读万卷书",
            "学习永远不晚",
            "事常与人违，事总在人为",
            "行路人，用足音代替叹息吧",
            "鞋底磨穿了，不等于路走到了头"};
    public void setWordLabel(JLabel wordLabel) {
        this.wordLabel = wordLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len = word.length;
        while (true){
            wordLabel.setText(word[i]);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i == len) {
                i = 0;
            }
        }
    }
}
