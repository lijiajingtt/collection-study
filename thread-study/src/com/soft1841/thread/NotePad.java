package com.soft1841.thread;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NotePad extends JFrame implements ActionListener  {
    private JMenu top1,top2,top3,top4,top5;
    private JMenuItem top6,topopen,top7,top8;
    private JMenuItem top9,top10;
    private JMenuItem top11,top12;
    private JMenuItem top13,top14;
    private JMenuItem top15,top16;
    private CardLayout cardLayout;
    private JPanel leftPanel;
    private JScrollPane rightPanel;
    private JTextArea contentArea;
    private File nowFile;
    private JLabel wordLabel;
    private StringSelection stringSelection;

    public NotePad() {
        init();
        setTitle("王者荣耀");
        setBounds(650, 350, 665, 445);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      private void init(){
          JSplitPane pane = new JSplitPane();
          leftPanel = new JPanel();
          cardLayout = new CardLayout();
          leftPanel.setLayout(cardLayout);
          contentArea = new JTextArea();
          JPanel rightPanel = new JPanel();
          rightPanel.add(contentArea);
          pane.setLeftComponent(leftPanel);
          pane.setRightComponent(rightPanel);
          pane.setDividerLocation(0.5);
          add(pane,BorderLayout.CENTER);
          Font font = new Font("仿宋", Font.BOLD, 20);
          wordLabel = new JLabel();
          wordLabel.setFont(font);
          add(wordLabel,BorderLayout.SOUTH);
          WordThread wt = new WordThread();
          wt.setWordLabel(wordLabel);
          new Thread(wt).start();


          //添加窗口事件处理程序，使用适配器
          this.addWindowListener(new WindowAdapter() {
              @Override
              public void windowClosing(WindowEvent e) {
                  System.exit(-1);
              }
          });

          //顶部菜单
          top1 = new JMenu("                           荣耀管理                      ");
          top2 = new JMenu("                           攻略                          ");
          top3 = new JMenu("                           英雄                          ");
          top4 = new JMenu("                           皮肤                          ");
          top5 = new JMenu("                           设置                                                ");
          JMenuBar top = new JMenuBar();
          top.add(top1);
          top.add(top2);
          top.add(top3);
          top.add(top4);
          top.add(top5);
          add(top, BorderLayout.NORTH);

          //文件(F)的组件
          top6 = new JMenuItem("    XJ    ");
          top6.addActionListener(this);
          topopen = new JMenuItem("    Open...    ");
          topopen.addActionListener(this);
          top7 = new JMenuItem("    Lsave...    ");
          top7.addActionListener(this);
          top8 = new JMenuItem("    Exit    ");
          top8.addActionListener(this);
          top1.add(top6);
          top1.add(topopen);
          top1.add(top7);
          top1.add(top8);

          top9 = new JMenuItem("    超链接    ");
          top9.addActionListener(this);
          top10 = new JMenuItem("    Time    ");
          top10.addActionListener(this);
          top8 = new JMenuItem("    退出    ");
          top8.addActionListener(this);
          top2.add(top9);
          top2.add(top10);
          top2.add(top8);


          top11 = new JMenuItem("    李白   ");
          top12 = new JMenuItem("   王昭君   ");
          top3.add(top11);
          top3.add(top12);


          top13 = new JMenuItem("    凤求凰    ");
          top14 = new JMenuItem("    凤凰于飞    ");
          top4.add(top13);
          top4.add(top14);


          top15 = new JMenuItem("    英雄背景故事    ");
          top15.addActionListener(this);
          top16 = new JMenuItem("    关于王者荣耀    ");
          top16.addActionListener(this);
          top5.add(top15);
          top5.add(top16);
      }
    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }catch (Exception e){
            e.printStackTrace();
        }
        new NotePad();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Clipboard clipboard=java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
        if (e.getSource() == top6){
            Top11TestThread td11 = new Top11TestThread();
            new Thread(td11).start();
        }
        if (e.getSource() == topopen){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setCurrentDirectory(new File("D:\\img"));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File[] files = fileChooser.getSelectedFiles();
                for (File f : files){
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
                                cardLayout.next(leftPanel);
                            }
                        });
                        leftPanel.add(imgLabel);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null,"IO操作异常");
                    }
                }
            }
        }
        if (e.getSource() == top7){
            FileWriter writer = null;
            try {
                FileDialog dialog = new FileDialog(this, "保存位置", FileDialog.SAVE);
                dialog.setVisible(true);
                nowFile = new File(dialog.getDirectory(), dialog.getFile());
                writer = new FileWriter(nowFile);
                writer.write(contentArea.getText());

            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            rightPanel.setVisible(false);
        }
        //退出功能
        if (e.getSource() == top8){
            this.dispose();

        }
        //超链接
        if (e.getSource() == top9){
            Top26Thread td26 = new Top26Thread();
            new Thread(td26).start();
        }
        //查看Time
        if (e.getSource() == top10){
            Top212Thread td212 = new Top212Thread();
            new Thread(td212).start();
        }
        //查看帮助,使用网络爬虫
        if (e.getSource() == top15){
            try {
                Top51Thread td51 = new Top51Thread();
                new Thread(td51).start();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        //帮助功能的实现，只是弹出一个String的对话框
        if (e.getSource() == top16){
            Top52Thread td52 = new Top52Thread();
            new Thread(td52).start();
        }
    }
}
class Top11TestThread extends JFrame implements Runnable{
    private JLabel accountLabel, passwordLabel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;
    public Top11TestThread(){
        init();
        setTitle("登录窗口");
        setSize(665, 445);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 500, 400);
        Font font = new Font("仿宋", Font.PLAIN, 30);
        accountLabel = new JLabel("Account:");
        accountLabel.setFont(font);
        accountLabel.setForeground(new Color(84, 199, 147));
        accountField = new JTextField();
        accountField.setFont(font);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(new Color(210, 87, 233));
        passwordField = new JPasswordField();
        passwordField.setFont(font);

        confirmButton = new JButton("登录");
        confirmButton.setFont(font);
        cancelButton = new JButton("取消");
        cancelButton.setFont(font);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountField.getText().trim();
                String password = String.valueOf(passwordField.getPassword());
                if ("1908".equals(account) && "1314".equals(password)) {
                    //关闭登录
                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    //打开主体线程
                    Top11Thread top11Thread = new Top11Thread();
                    new Thread(top11Thread).start();
                }
            }
        });
        accountLabel.setBounds(60, 150, 100, 35);
        accountField.setBounds(200, 150, 260, 35);
        passwordLabel.setBounds(60, 220, 100, 35);
        passwordField.setBounds(200, 220, 260, 35);
        confirmButton.setBounds(100,300,100,35);
        cancelButton.setBounds(280,300,100,35);
        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(confirmButton);
        panel.add(cancelButton);
        add(panel);
    }

    public static void main(String[] args) {
        new Top11TestThread();
    }

    @Override
    public void run() {

    }
}
class Top11Thread extends JFrame implements Runnable {
    public Top11Thread(){
        init();
        setTitle("幻彩荣耀");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 665, 445);
    }
    public void init(){
        ShadePanel shadePanel = new ShadePanel();
        add(shadePanel);

    }
    @Override
    public void run() {

    }
    class ShadePanel extends JPanel {
        public ShadePanel(){
            java.util.Timer timer = new Timer();
            timer.schedule(timerTask,0,2000);

        }
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        };
        @Override
        protected void paintComponent(Graphics g2) {
            Graphics2D g = (Graphics2D) g2;
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            Color[] color = {Color.orange,Color.cyan,Color.pink,Color.yellow};
            Random r = new Random();
            int i = r.nextInt(2);
            int j = r.nextInt(3);
            //创建填充模式对象
            GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
            g.setPaint(paint);
            g.fillRect(i, j, width, height);
        }
    }
    public static void main(String[] args) {
        new Top11Thread();
    }
}
class Top26Thread extends Thread {
    Desktop desktop = Desktop.getDesktop();
    URI uri; //创建URI统一资源标识符
    {
        try {
            uri = new URI("http://www.taobao.com");
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Top212Thread extends JFrame implements Runnable {
    private JLabel timeLabel;
    private TimerTask timerTask;
    public Top212Thread(){
        init();
        setTitle("Timer窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 310, 130);
    }
    public void init(){
    }
    @Override
    public void run() {
        Font font = new Font("微软雅黑",Font.BOLD,20);
        timeLabel = new JLabel();
        timeLabel.setFont(font);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                while (true){
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date currentTime = new Date();
                    String a = format.format(currentTime);
                    timeLabel.setText(a);
                    add(timeLabel,BorderLayout.SOUTH);
                }
            }
        } ;
        Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);
        add(timeLabel,BorderLayout.CENTER);
    }
    public static void main(String[] args) {
        new Top212Thread();
    }
}
class Top51Thread extends JFrame implements Runnable{
    private JTextArea textArea;
    public Top51Thread() throws IOException {
        init();
        setTitle("网络爬取窗口");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(350, 350, 665, 445);
    }
    public void init() throws IOException {
        //1,指定目标页面链接
        String url = "https://baike.baidu.com/item/李白/19182206?fr=aladdin";
        //2,建立目标页面链接
        Connection connection = Jsoup.connect(url);
        //3,解析目标页面
        Document document = connection.get();
        //4,获取页面中所有的class为content的元素，本例在页面中可以检查元素，是div
        Elements elements = document.getElementsByClass("body-wrapper");
//        System.out.println(elements.size());
        for (Element element : elements) {
            //取出div的子元素div-h4-a
            Element link = element;
            //得到a标记的文字内容
            String titleString = link.text();
            textArea = new JTextArea(titleString);
        }
        JScrollPane jScrollPane = new JScrollPane(textArea);
        add(jScrollPane);
    }
    @Override
    public void run() {

    }

    public static void main(String[] args) throws IOException {
        new Top51Thread();
    }
}
class Top52Thread extends Thread{
    Object[] possibleValues = { "王者峡谷 ", "微信179区", "开始游戏" };
    Object selectedValue = JOptionPane.showInputDialog(null, "最终解释权归深圳腾讯科技有限公司所有（c）", "天美工作室",
            JOptionPane.INFORMATION_MESSAGE, null,
            possibleValues, possibleValues[0]);
}
class WordThread extends Thread {
    private JLabel wordLabel;
    private String[]word = {"凤兮凤兮归故乡，遨游四海求其凰。","三尺长剑，斩不尽相思情缠。","邂逅你，是生生世世的宿命。"};
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



