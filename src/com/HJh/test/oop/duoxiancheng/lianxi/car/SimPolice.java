package com.HJh.test.oop.duoxiancheng.lianxi.car;

public class SimPolice {
    private boolean intersectionBusy = false;
    private String currentCar = null;

    public synchronized void checkAndGo(SimCar car) {
        int carPos = car.getCarPos();
        int speed = car.getSpeed();
        int direction = car.getDirection();
        String carName = Thread.currentThread().getName();

        int intersectionStart = CrossroadsPanel.getIntersectionStart();
        int intersectionEnd = CrossroadsPanel.getIntersectionEnd();

        boolean willEnterIntersection = false;

        if (direction == SimCar.LEFT_TO_RIGHT) {
            int frontPos = carPos + 40;
            if (frontPos < intersectionStart && frontPos + speed >= intersectionStart) {
                willEnterIntersection = true;
            }
        } else {
            int frontPos = carPos + 40;
            if (frontPos < intersectionStart && frontPos + speed >= intersectionStart) {
                willEnterIntersection = true;
            }
        }

        if (willEnterIntersection && intersectionBusy) {
            System.out.println(carName + " 在路口前等待...");
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (willEnterIntersection) {
            intersectionBusy = true;
            currentCar = carName;
            System.out.println(carName + " 正在通过路口");
        }

        if (intersectionBusy && currentCar != null && currentCar.equals(carName)) {
            if (direction == SimCar.LEFT_TO_RIGHT) {
                if (carPos > intersectionEnd) {
                    intersectionBusy = false;
                    currentCar = null;
                    System.out.println(carName + " 已通过路口");
                    notifyAll();
                }
            } else {
                if (carPos > intersectionEnd) {
                    intersectionBusy = false;
                    currentCar = null;
                    System.out.println(carName + " 已通过路口");
                    notifyAll();
                }
            }
        }
    }

    public synchronized boolean isIntersectionBusy() {
        return intersectionBusy;
    }
}