package com.gmo.sae.aoc.day6;

import com.gmo.sae.aoc.Point;

import java.util.Comparator;

public class LocationDistanceComparator implements Comparator<Location> {

    private Point point;

    public LocationDistanceComparator(int x, int y){
        this.point = new Point(x, y);
    }


    @Override
    public int compare(Location o1, Location o2) {
        return o1.getPoint().distance(point) - o2.getPoint().distance(point);
    }
}
