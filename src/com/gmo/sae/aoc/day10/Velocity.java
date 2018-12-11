package com.gmo.sae.aoc.day10;

import com.gmo.sae.aoc.Point;

public class Velocity {

    private int x;
    private int y;

    public Velocity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point move(Point point, int times){
        point.move(x*times, y*times);
        return point;
    }
}
