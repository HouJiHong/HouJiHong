package com.HJh.test.oop.duoxiancheng.lianxi.car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CrossroadsFrame extends JFrame {
    private CrossroadsPanel panel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    public CrossroadsFrame() {
        setTitle("汽车过十字路口动画");
        setSize(450, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new CrossroadsPanel();

        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        startButton = new JButton("开始");
        stopButton = new JButton("暂停");
        resetButton = new JButton("重置");

        Font font = new Font("微软雅黑", Font.PLAIN, 14);
        startButton.setFont(font);
        stopButton.setFont(font);
        resetButton.setFont(font);

        startButton.addActionListener(e -> panel.startAnimation());
        stopButton.addActionListener(e -> panel.stopAnimation());
        resetButton.addActionListener(e -> panel.resetAnimation());

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.shutdown();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CrossroadsFrame frame = new CrossroadsFrame();
            frame.setVisible(true);
        });
    }
}