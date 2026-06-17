package com.HJh.test.oop.duoxiancheng.lianxi.car;

import java.awt.*;

public class SimCar extends Thread {
    public static final int LEFT_TO_RIGHT = 1;
    public static final int TOP_TO_BOTTOM = 2;

    private int carPos = 0;
    private int lastPos = -1;
    private int speed;
    private int direction;
    private Color color;
    private SimPolice police;

    private volatile boolean running = true;
    private volatile boolean paused = false;
    private final Object pauseLock = new Object();

    public SimCar(SimPolice police, int direction, int speed, Color color) {
        this.police = police;
        this.direction = direction;
        this.speed = speed;
        this.color = color;
    }

    public void startCar() {
        running = true;
        paused = false;
        if (!this.isAlive()) {
            this.start();
        }
    }

    public void pauseCar() {
        paused = true;
    }

    public void resumeCar() {
        paused = false;
        synchronized (pauseLock) {
            pauseLock.notifyAll();
        }
    }

    public void shutdown() {
        running = false;
        synchronized (pauseLock) {
            pauseLock.notifyAll();
        }
        this.interrupt();
    }

    @Override
    public void run() {
        while (running) {
            synchronized (pauseLock) {
                while (paused && running) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }

            if (!running) break;

            police.checkAndGo(this);

            carPos += speed;
            if (carPos >= 400) {
                carPos = 0;
                lastPos = -1;
            }

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (direction == LEFT_TO_RIGHT) {
            drawLeftToRight(g);
        } else {
            drawTopToBottom(g);
        }
        lastPos = carPos;
    }

    private void drawLeftToRight(Graphics2D g) {
        if (lastPos >= 0 && lastPos != carPos) {
            g.setColor(getBackground());
            g.fillRect(lastPos, 185, 42, 34);
        }

        int x = carPos;
        int y = 185;

        g.setColor(color);
        g.fillRoundRect(x, y, 40, 30, 8, 8);

        g.setColor(new Color(200, 230, 255));
        g.fillRoundRect(x + 8, y + 3, 10, 10, 4, 4);
        g.fillRoundRect(x + 22, y + 3, 10, 10, 4, 4);

        g.setColor(new Color(255, 255, 200));
        g.fillOval(x + 32, y + 4, 6, 6);
        g.setColor(new Color(255, 0, 0));
        g.fillOval(x, y + 4, 6, 6);
        g.fillOval(x, y + 20, 6, 6);

        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + 3, y + 25, 10, 8);
        g.fillOval(x + 27, y + 25, 10, 8);
        g.setColor(Color.GRAY);
        g.fillOval(x + 5, y + 27, 6, 4);
        g.fillOval(x + 29, y + 27, 6, 4);
    }

    private void drawTopToBottom(Graphics2D g) {
        if (lastPos >= 0 && lastPos != carPos) {
            g.setColor(getBackground());
            g.fillRect(185, lastPos, 34, 42);
        }

        int x = 185;
        int y = carPos;

        g.setColor(color);
        g.fillRoundRect(x, y, 30, 40, 8, 8);

        g.setColor(new Color(200, 230, 255));
        g.fillRoundRect(x + 3, y + 8, 10, 10, 4, 4);
        g.fillRoundRect(x + 3, y + 22, 10, 10, 4, 4);

        g.setColor(new Color(255, 255, 200));
        g.fillOval(x + 4, y + 32, 6, 6);
        g.setColor(new Color(255, 0, 0));
        g.fillOval(x + 4, y, 6, 6);
        g.fillOval(x + 20, y, 6, 6);

        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + 25, y + 3, 8, 10);
        g.fillOval(x + 25, y + 27, 8, 10);
        g.setColor(Color.GRAY);
        g.fillOval(x + 27, y + 5, 4, 6);
        g.fillOval(x + 27, y + 29, 4, 6);
    }

    private Color getBackground() {
        return new Color(238, 238, 238);
    }

    public int getCarPos() { return carPos; }
    public int getSpeed() { return speed; }
    public int getDirection() { return direction; }
}