package com.HJh.test.oop.duoxiancheng.lianxi.car;

import javax.swing.*;
import java.awt.*;

public class CrossroadsPanel extends JPanel implements Runnable {
    private static final int ROAD_WIDTH = 40;
    private static final int INTERSECTION_START = 180;
    private static final int INTERSECTION_END = 220;
    private static final int PANEL_SIZE = 400;

    private SimCar lrCar;
    private SimCar tbCar;
    private SimPolice police;

    private Thread animThread;
    private volatile boolean running = false;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();

    private static final Color COLOR_LR_CAR = new Color(0, 180, 0);
    private static final Color COLOR_TB_CAR = new Color(255, 180, 0);

    public CrossroadsPanel() {
        setPreferredSize(new Dimension(PANEL_SIZE, PANEL_SIZE));
        setBackground(Color.WHITE);
        initCars();
    }

    private void initCars() {
        police = new SimPolice();
        lrCar = new SimCar(police, SimCar.LEFT_TO_RIGHT, 8, COLOR_LR_CAR);
        tbCar = new SimCar(police, SimCar.TOP_TO_BOTTOM, 8, COLOR_TB_CAR);
    }

    public void startAnimation() {
        if (running && !paused) {
            return;
        }
        if (!running) {
            initCars();
            running = true;
            paused = false;
            animThread = new Thread(this, "AnimationThread");
            animThread.start();
            lrCar.startCar();
            tbCar.startCar();
        } else if (paused) {
            resumeAnimation();
        }
    }

    public void stopAnimation() {
        if (running && !paused) {
            paused = true;
            lrCar.pauseCar();
            tbCar.pauseCar();
        }
    }

    private void resumeAnimation() {
        if (running && paused) {
            paused = false;
            lrCar.resumeCar();
            tbCar.resumeCar();
            synchronized (pauseLock) {
                pauseLock.notifyAll();
            }
        }
    }

    public void resetAnimation() {
        running = false;
        paused = false;
        if (animThread != null) {
            animThread.interrupt();
            animThread = null;
        }
        lrCar.shutdown();
        tbCar.shutdown();
        initCars();
        repaint();
    }

    public void shutdown() {
        running = false;
        paused = false;
        if (animThread != null) {
            animThread.interrupt();
            animThread = null;
        }
        lrCar.shutdown();
        tbCar.shutdown();
    }

    @Override
    public void run() {
        while (running) {
            synchronized (pauseLock) {
                while (paused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawCrossroads(g2d);

        if (lrCar != null) lrCar.draw(g2d);
        if (tbCar != null) tbCar.draw(g2d);

        drawStatus(g2d);
    }

    private void drawCrossroads(Graphics2D g) {
        g.setColor(new Color(80, 80, 80));
        g.fillRect(0, INTERSECTION_START, PANEL_SIZE, ROAD_WIDTH);
        g.fillRect(INTERSECTION_START, 0, ROAD_WIDTH, PANEL_SIZE);

        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        int y = INTERSECTION_START + ROAD_WIDTH / 2;
        for (int x = 10; x < INTERSECTION_START - 10; x += 20) {
            g.drawLine(x, y, x + 10, y);
        }
        for (int x = INTERSECTION_END + 10; x < PANEL_SIZE - 10; x += 20) {
            g.drawLine(x, y, x + 10, y);
        }

        int x = INTERSECTION_START + ROAD_WIDTH / 2;
        for (int yPos = 10; yPos < INTERSECTION_START - 10; yPos += 20) {
            g.drawLine(x, yPos, x, yPos + 10);
        }
        for (int yPos = INTERSECTION_END + 10; yPos < PANEL_SIZE - 10; yPos += 20) {
            g.drawLine(x, yPos, x, yPos + 10);
        }

        g.setColor(new Color(255, 255, 0, 80));
        g.fillRect(INTERSECTION_START, INTERSECTION_START, ROAD_WIDTH, ROAD_WIDTH);

        g.setColor(Color.YELLOW);
        g.setStroke(new BasicStroke(2));
        g.drawRect(INTERSECTION_START, INTERSECTION_START, ROAD_WIDTH, ROAD_WIDTH);
    }

    private void drawStatus(Graphics2D g) {
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRoundRect(10, 10, 160, 60, 10, 10);
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 12));
        String status = paused ? "● 已暂停" : (running ? "● 运行中" : "● 已停止");
        g.drawString(status, 20, 32);
        g.drawString("绿灯：水平方向通过", 20, 52);

        g.setColor(new Color(0, 0, 0, 150));
        g.fillRoundRect(PANEL_SIZE - 110, 10, 100, 40, 10, 10);
        g.setColor(Color.WHITE);
        g.drawString("路口: " + (police.isIntersectionBusy() ? "🚗 占用" : "✅ 空闲"),
                PANEL_SIZE - 100, 35);
    }

    public static int getIntersectionStart() {
        return INTERSECTION_START;
    }

    public static int getIntersectionEnd() {
        return INTERSECTION_END;
    }

    public static int getRoadWidth() {
        return ROAD_WIDTH;
    }
}