package com.HJh.test.oop.guiyongfa.tuxiangchakan.UI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PictureShow extends JFrame implements ActionListener {
    private JLabel pictureLabel;
    private JButton prevButton;
    private JButton nextButton;
    private JButton playButton;
    private JLabel timeLabel;
    private ArrayList<String> imageList;
    private int currentIndex;
    private Timer playTimer;
    private boolean isPlaying;

    public PictureShow() {
        this.setTitle("图片显示");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        // 初始化图片列表
        imageList = new ArrayList<>();
        currentIndex = 0;
        isPlaying = false;

        // 设置布局
        setLayout(new BorderLayout());

        // 顶部：菜单栏（文件下拉框）
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("文件");
        JMenuItem openItem = new JMenuItem("打开");
        openItem.addActionListener(this);
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // 按钮面板：上一个、下一个、播放
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        prevButton = new JButton("上一个");
        prevButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        prevButton.setPreferredSize(new Dimension(100, 35));
        prevButton.addActionListener(this);
        prevButton.setEnabled(false);

        nextButton = new JButton("下一个");
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        nextButton.setPreferredSize(new Dimension(100, 35));
        nextButton.addActionListener(this);
        nextButton.setEnabled(false);

        playButton = new JButton("播放");
        playButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        playButton.setPreferredSize(new Dimension(100, 35));
        playButton.addActionListener(this);
        playButton.setEnabled(false);

        buttonPanel.add(prevButton);
        buttonPanel.add(Box.createHorizontalStrut(30));
        buttonPanel.add(nextButton);
        buttonPanel.add(Box.createHorizontalStrut(30));
        buttonPanel.add(playButton);

        add(buttonPanel, BorderLayout.NORTH);

        // 图片显示区域
        pictureLabel = new JLabel();
        pictureLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureLabel.setVerticalAlignment(JLabel.CENTER);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        pictureLabel.setBackground(Color.WHITE);
        pictureLabel.setOpaque(true);

        JScrollPane scrollPane = new JScrollPane(pictureLabel);
        add(scrollPane, BorderLayout.CENTER);

        // 底部：时间显示
        JPanel timePanel = new JPanel();
        timePanel.setBackground(Color.DARK_GRAY);
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        timeLabel.setForeground(Color.WHITE);
        timePanel.add(timeLabel);
        add(timePanel, BorderLayout.SOUTH);

        // 更新时间
        updateTime();
        Timer timeTimer = new Timer();
        timeTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        }, 0, 1000);

        // 加载picture目录下的图片
        loadPictureImages();
    }

    // 加载picture目录下的图片
    private void loadPictureImages() {
        // 尝试从项目根目录下的picture文件夹加载
        String picturePath = "picture";
        File pictureDir = new File(picturePath);

        // 如果picture目录不存在，尝试从src目录下查找
        if (!pictureDir.exists()) {
            picturePath = "src/com/HJh/test/oop/guiyongfa/tuxiangchakan/resource/picture";
            pictureDir = new File(picturePath);
        }

        // 如果还是不存在，尝试resource目录（保留兼容）
        if (!pictureDir.exists()) {
            picturePath = "src/com/HJh/test/oop/guiyongfa/tuxiangchakan/resource";
            pictureDir = new File(picturePath);
        }

        if (pictureDir.exists() && pictureDir.isDirectory()) {
            File[] files = pictureDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    String extension = getFileExtension(file);
                    if (extension != null && extension.matches("(?i)(jpg|jpeg|png|gif|bmp)")) {
                        imageList.add(file.getAbsolutePath());
                    }
                }
            }
        }

        // 如果有图片，显示第一张
        if (imageList.size() > 0) {
            displayImage(currentIndex);
            prevButton.setEnabled(true);
            nextButton.setEnabled(true);
            playButton.setEnabled(true);
        } else {
            // 如果没有找到图片，显示提示
            pictureLabel.setText("未找到图片，请通过'文件'菜单添加图片");
        }
    }

    // 更新时间显示
    private void updateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeLabel.setText("当前时间: " + sdf.format(new Date()));
    }

    // 显示指定索引的图片
    private void displayImage(int index) {
        if (index >= 0 && index < imageList.size()) {
            currentIndex = index;
            ImageIcon icon = new ImageIcon(imageList.get(currentIndex));
            Image image = icon.getImage();

            // 缩放图片以适应显示区域（使用滚动面板的大小）
            int maxWidth = 750; // 设置一个合理的最大宽度
            int maxHeight = 480; // 设置一个合理的最大高度

            if (image.getWidth(null) > maxWidth || image.getHeight(null) > maxHeight) {
                double widthRatio = (double) maxWidth / image.getWidth(null);
                double heightRatio = (double) maxHeight / image.getHeight(null);
                double ratio = Math.min(widthRatio, heightRatio);

                int newWidth = (int) (image.getWidth(null) * ratio);
                int newHeight = (int) (image.getHeight(null) * ratio);
                image = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            }

            pictureLabel.setIcon(new ImageIcon(image));
        }
    }

    // 获取文件扩展名
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastDotIndex = name.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < name.length() - 1) {
            return name.substring(lastDotIndex + 1);
        }
        return null;
    }

    // 播放/暂停图片
    private void togglePlay() {
        if (isPlaying) {
            // 停止播放
            playTimer.cancel();
            playButton.setText("播放");
            isPlaying = false;
        } else {
            // 开始播放
            playButton.setText("暂停");
            isPlaying = true;
            playTimer = new Timer();
            playTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        currentIndex++;
                        if (currentIndex >= imageList.size()) {
                            currentIndex = 0;
                        }
                        displayImage(currentIndex);
                    });
                }
            }, 0, 2000); // 每2秒切换一张图片
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("打开")) {
            // 打开文件管理器选择图片
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("选择图片");
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) return true;
                    String extension = getFileExtension(f);
                    return extension != null && extension.matches("(?i)(jpg|jpeg|png|gif|bmp)");
                }

                @Override
                public String getDescription() {
                    return "图片文件 (*.jpg, *.png, *.gif, *.bmp)";
                }
            });

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // 添加到图片列表并显示
                imageList.add(selectedFile.getAbsolutePath());
                currentIndex = imageList.size() - 1;
                displayImage(currentIndex);

                // 启用按钮
                prevButton.setEnabled(true);
                nextButton.setEnabled(true);
                playButton.setEnabled(true);
            }
        } else if (command.equals("上一个")) {
            if (currentIndex > 0) {
                displayImage(currentIndex - 1);
            } else {
                displayImage(imageList.size() - 1); // 循环到最后一张
            }
        } else if (command.equals("下一个")) {
            if (currentIndex < imageList.size() - 1) {
                displayImage(currentIndex + 1);
            } else {
                displayImage(0); // 循环到第一张
            }
        } else if (command.equals("播放") || command.equals("暂停")) {
            togglePlay();
        }
    }
}