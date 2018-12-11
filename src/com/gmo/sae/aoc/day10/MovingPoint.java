package com.gmo.sae.aoc.day10;

import com.gmo.sae.aoc.Point;

public class MovingPoint {

    private Point point;

    private Velocity velocity;

    public MovingPoint(Point point, Velocity velocity){
        this.point = point;
        this.velocity = velocity;
    }

    public void move(){
        velocity.move(point, 1);
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point){
        this.point=point;
    }

    public Integer getX(){
        return point.getX();
    }

    public Integer getY(){
        return point.getY();
    }

    public Velocity getVelocity() {
        return velocity;
    }
}
