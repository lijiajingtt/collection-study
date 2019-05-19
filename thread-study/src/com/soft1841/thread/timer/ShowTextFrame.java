package com.soft1841.thread.timer;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ShowTextFrame extends JFrame implements ActionListener{
    JTextArea jta;//该文本域用于显示文本信息
    JTextField jtf;//该文本框,用于填写文件路径
    JLabel jl;//该标签用于保存读取到的行数
    JButton jbt;//按钮
    public ShowTextFrame() {
        jtf = new JTextField(18);
        jbt = new JButton("读取并显示");
        jbt.addActionListener(this);
        JPanel  jp1 = new JPanel();
        jp1.add(jtf);
        jp1.add(jbt);
        add(jp1,BorderLayout.NORTH);
        jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);//文本域添加到滚动面板
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//垂直滚动条一直显示
        add(jsp);

        jl = new JLabel("文件共有0行");
        JPanel jp2 = new JPanel();
        jp2.add(jl);
        add(jp2,BorderLayout.SOUTH);
        setTitle("显示文本");//窗口标题
        setSize(380, 320);
        setLocationRelativeTo(null);//窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(jbt==e.getSource()){
            String fp = jtf.getText().trim();
            Info info = getInfo(fp);
            jta.setText(info.txt);//把文本信息显示到文本域
            jl.setText("文件共有"+info.lines+"行");//把行数显示显示到JLabel
        }
    }

    public Info getInfo(String fp){//通过文件路径,获取文件信息(字符串信息和行数信息)
        StringBuffer txtbuf=new StringBuffer();
        int lines=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fp));
            String hasRead=null;
            while((hasRead=br.readLine())!=null){
                txtbuf.append(hasRead+"\n");
                lines++;
            }
            br.close();//IO流用完记得关闭
        } catch (Exception e) {
            //当IO出现异常时,要进行提示
            JOptionPane.showMessageDialog(this, "文件读取错误,确认文件存在,\n或者没有被其他文件打开.","IO错误",JOptionPane.ERROR_MESSAGE);;
        }
        return new Info(txtbuf.toString(), lines);
    }

    public static void main(String[] args) {
        new ShowTextFrame();//创建窗口实例
    }


}
class Info{//辅助类, 用于传递信息
    String txt;//文字信息
    int lines;// 行数信息
    public Info(String txt, int lines) {
        this.txt = txt;
        this.lines = lines;
    }
}