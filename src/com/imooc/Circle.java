package com.imooc;

import java.awt.*;

public class Circle {
    public int x, y;
    private int r;
    public int vx, vy;
    public boolean isFilled = false;

    public Circle() {
    }

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }

    public void move(int minx, int miny, int maxX, int maxY) {
        x += vx;
        y += vy;

        checkCollsion(minx, miny, maxX, maxY);
    }

    public boolean contain(Point p){
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r * r;
    }

    //碰撞检测
    private void checkCollsion(int minx, int miny, int maxX, int maxY) {
        if (x - r < minx) {
            x = r;
            vx = -vx;
        }
        if (x + r >= maxX) {
            x = maxX - r;
            vx = -vx;
        }
        if (y - r < miny) {
            y = r;
            vy = -vy;
        }
        if (y + r >= maxY) {
            y = maxY - r;
            vy = -vy;
        }
    }
}
