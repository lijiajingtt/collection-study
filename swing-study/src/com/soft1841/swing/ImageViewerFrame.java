package com.soft1841.swing;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class ImageViewerFrame extends JFrame implements ActionListener {
    private JButton chooseBtn, preBtn, nextBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel, bottomPanel;
    private CardLayout cardLayout;

    public ImageViewerFrame() {
        init();
        setTitle("使用卡片布局实现多图浏览功能");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        bottomPanel = new JPanel();
        chooseBtn = new JButton("选择图片");
        add(chooseBtn, BorderLayout.NORTH);
        chooseBtn.addActionListener(this);
        preBtn = new JButton("前一张");
        nextBtn = new JButton("后一张");
        bottomPanel.add(chooseBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        chooseBtn.addActionListener(this);
        preBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        add(bottomPanel, BorderLayout.SOUTH);
        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(53, 144, 193));
        add(centerPanel);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageViewerFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //用户选择了文件
        if (e.getSource() == chooseBtn) {
            //获取选中的文件
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\img"));
            //设置文件为多选模式
            fileChooser.setMultiSelectionEnabled(true);
            //打开对话框，阻塞模式
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
//                System.out.println(files.length);
                for (File f : files) {
                    System.out.println(f.getAbsolutePath());
                    //对每个f文件，创建字节输入流读入字节数组，构建Icon，并设置给JLabel
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream inputStream = new FileInputStream(f);
                        inputStream.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imgLabel = new JLabel();
                        imgLabel.setIcon(icon);
                        centerPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO异常");
                    }
                }
            }
        }
                    if (e.getSource() == preBtn) {
                        cardLayout.previous(centerPanel);
                    }
                    if (e.getSource() == nextBtn) {
                        cardLayout.previous(centerPanel);
                    }
                }
            }
