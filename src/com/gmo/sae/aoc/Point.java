package com.gmo.sae.aoc;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int distance(int x, int y){
        int distanceX = Math.abs(this.x - x);
        int distanceY = Math.abs(this.y - y);

        return  distanceX + distanceY;
    }

    public int distance(Point point){
        return distance(point.getX(), point.getY());
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int x, int y){
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public boolean equals(Point point){
        return this.getX()==point.getX() && this.getY()==point.getY();
    }
}
