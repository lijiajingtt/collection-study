package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class GroupFrame extends JFrame implements ActionListener {
    private JPanel bottomPanel,centerPanel;
    private JMenu m1,m2,m3,m4,m5,m6;
    private JMenu n1,n2,n3,n4,n5,n6;
    private JMenuItem n21,n22,n23;
    private JButton a1,a2;
    private CardLayout cardLayout;
    private JFileChooser fileChooser;

    public GroupFrame(){
        init();
        setTitle("王者荣耀");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 350, 665, 445);
        add(centerPanel,BorderLayout.CENTER);
    }
        public void init(){
        //创建中间面板，并设置布局为卡片布局
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(53, 144, 193));
        add(centerPanel,BorderLayout.CENTER);
        //顶部菜单
        m1 = new JMenu("刺客");
        m2 = new JMenu("战士");
        m3 = new JMenu("射手");
        m4 = new JMenu("法师");
        m5 = new JMenu("辅助");
        m6 = new JMenu("坦克");
        JMenuBar m = new JMenuBar();
        m.add(m1);
        m.add(m2);
        m.add(m3);
        m.add(m4);
        m.add(m5);
        m.add(m6);
        add(m,BorderLayout.NORTH);
        n1 = new JMenu("娜可露露");
        n2 = new JMenu("李白");
        n3 = new JMenu("橘右京");
        n4 = new JMenu("关羽");
        n5 = new JMenu("赵云");
        n6 = new JMenu("刘备");
        //刺客菜单
        m1.add(n1);
        m1.add(n2);
        m1.add(n3);
        m1.add(n4);
        m1.add(n5);
        m1.add(n6);
        //底部面板
        bottomPanel = new JPanel();
        a1 = new JButton("下一个");
        a2 = new JButton("撤回");
        bottomPanel.add(a1);
        bottomPanel.add(a2);
        a1.addActionListener(this);
        a2.addActionListener(this);
        add(bottomPanel,BorderLayout.SOUTH);
        //李白面板
        n21 = new JMenuItem("皮肤");
        n21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == n21){
                    fileChooser = new JFileChooser();
                    fileChooser.setCurrentDirectory(new File("D:\\img"));
                    //设置文件为多选模式
                    fileChooser.setMultiSelectionEnabled(true);
                    //打开对话框，阻塞模式
                    int result = fileChooser.showOpenDialog(null);
                    //用户选择了文件
                    if (result == JFileChooser.APPROVE_OPTION){
                        //获取选中的所有文件
                        File[] files = fileChooser.getSelectedFiles();
//                System.out.println(files.length);
                        //遍历文件数组
                        for (File f : files){
                            System.out.println(f.getAbsolutePath());
                            //对每个f文件，创建字节输入流读入字节数组，构建Icon,并设置给JLabel
                            try {
                                byte[] bytes = new byte[(int) f.length()];
                                InputStream inputStream = new FileInputStream(f);
                                inputStream.read(bytes);
                                Icon icon = new ImageIcon(bytes);
                                JLabel imgLabel = new JLabel();
                                imgLabel.setIcon(icon);

                                JPopupMenu jPopupMenu = new JPopupMenu();
                                JMenuItem menuItem = new JMenuItem();
                                JPanel panelLabel = new JPanel();
                                JLabel labelSomeText = new JLabel("Some text");
                                labelSomeText.setFont(menuItem.getFont());
                                labelSomeText.setForeground(menuItem.getForeground());
                                panelLabel.add(labelSomeText);
                                jPopupMenu.add(panelLabel);

                                imgLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        System.out.println("图片被点击");
                                    }
                                });
                                centerPanel.add(imgLabel);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null,"IO操作异常");
                            }
                        }
                    }

                }

            }
        });
        n22 = new JMenuItem("英雄机制");
        n23 = new JMenuItem("背景故事");
        n22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == n22){
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(true);
                    fileChooser.setCurrentDirectory(new File("D:\\img"));
                    int result = fileChooser.showOpenDialog(null);
                    if (result == JFileChooser.APPROVE_OPTION){
                        File[] files = fileChooser.getSelectedFiles();
                        for (File f : files){
                            System.out.println(f.getAbsolutePath());
                            //对每个f文件，创建字节输入流读入字节数组，构建Icon,并设置给JLabel
                            try {
                                byte[] bytes = new byte[(int) f.length()];
                                InputStream inputStream = new FileInputStream(f);
                                inputStream.read(bytes);
                                Icon icon = new ImageIcon(bytes);
                                JLabel imgLabel = new JLabel();
                                imgLabel.setIcon(icon);
                                imgLabel.addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        System.out.println("图片被点击");
                                    }
                                });
                                centerPanel.add(imgLabel);
                            } catch (IOException e1) {
                                JOptionPane.showMessageDialog(null,"IO操作异常");
                            }
                        }
                    }

                }
            }
        });
        n2.add(n21);
        n2.add(n22);
        n2.add(n23);
    }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new GroupFrame();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == a1){
            cardLayout.next(centerPanel);
        }
        if (e.getSource() == a2){
            cardLayout.previous(centerPanel);
        }

    }
}
