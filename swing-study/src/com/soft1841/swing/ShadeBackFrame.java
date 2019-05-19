package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * 渐变色背景背景
 */
public class ShadeBackFrame extends JFrame implements ActionListener {
    private int width;
    private int height;

    private  JLabel accoutLabel ,passwordLabel ;
    private  JTextField accountField;
    private  JPasswordField passwordField;
    private  JButton comfirmButton ;
    private JButton cancleButton;

    public ShadeBackFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.width;
        height = screenSize.height;
        init();
        setTitle("渐变色背景窗体");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {

        Font font = new Font("微软雅黑",Font.PLAIN,28);
        accoutLabel = new JLabel("账号");
        accoutLabel.setFont(font);
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("密码");
        passwordLabel.setFont(font);
        passwordField = new JPasswordField();
        passwordField.setFont(font);
        cancleButton = new JButton("取消");
        comfirmButton = new JButton("登陆");
        comfirmButton.setFont(font);
        cancleButton.setFont(font);
        //窗口布局设为空布局，需要给每个组件定位
        setLayout(null);
        //setBounds 方法的四个参数分别为组件x、y坐标，组件宽高
        accoutLabel.setBounds(640,200,100,35);
        accountField.setBounds(760,200,300,35);
        passwordLabel.setBounds(640,350,100,35);
        passwordField.setBounds(760,350,300,35);

        comfirmButton.setBounds(700,600,170,50);
        comfirmButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        cancleButton.setBounds(900,600,170,50);
        cancleButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        add(accoutLabel);
        add(accountField);
        add(passwordLabel);
        add(passwordField);
        add(comfirmButton);
        add(cancleButton);

        setLayout(null);
        ShadePanel shadePanel = new ShadePanel();
        shadePanel.setLayout(null);
        shadePanel.setBounds(0, 0, width, height);

        ImgPanel imgPanel = new ImgPanel();
        imgPanel.setLayout(null);
        imgPanel.setImgPath("bg2.jpg");
        imgPanel.setBounds(500, 150, 800, 600);

        MyButton loginBtn = new MyButton();
        loginBtn.setPreferredSize(new Dimension(200, 80));
        loginBtn.setBgIcon("bg.jpg");
        loginBtn.setFocusPainted(false);
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);
        loginBtn.setBounds(320, 280, 200, 80);

        imgPanel.add(loginBtn);
        shadePanel.add(imgPanel);
        add(shadePanel);
    }

    public static void main(String[] args) {
        new ShadeBackFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "播放音乐");
    }
}

/**
 * 继承JPanel的自定义面板，实现渐变背景色，paintComponent重绘组件
 */
class ShadePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(0, 0, Color.gray, 0, height, Color.blue);
        g.setPaint(paint);
        g.fillRect(0, 0, width, height);
    }
}

/**
 * 继承JPanel的自定义面板，绘制背景图
 */
class ImgPanel extends JPanel {
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/swing-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}

/**
 * 自定义按钮，绘制背景图
 */
class MyButton extends JButton {
    private String bgIcon;

    public void setBgIcon(String bgIcon) {
        this.bgIcon = bgIcon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/swing-study/src/img/" + bgIcon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}