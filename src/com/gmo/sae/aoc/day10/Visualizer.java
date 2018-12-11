package com.gmo.sae.aoc.day10;

import com.gmo.sae.aoc.Point;

import java.util.*;

public class Visualizer {




    public List<String> visualize(MovingPoint[] points) {

        for (MovingPoint point : points) {
            point.move();
        }

        //Anzahl der Punkte mit direkten Nachbarn berechen
        int pointWithNeighbours = 0;
        for (MovingPoint point : points) {
            if (countNeighbor(points, point.getPoint(), 1) > 1) {
                pointWithNeighbours++;
            }
        }

        //Mind. 90% benötigen einen direkten Nachbarn
        if(pointWithNeighbours < (points.length * 0.9f)){
            return null;
        }

        int maxX = Arrays.asList(points)
                .stream()
                .max(Comparator.comparing(MovingPoint::getX)).orElseThrow(NoSuchElementException::new).getX();


        int maxY = Arrays.asList(points)
                .stream()
                .max(Comparator.comparing(MovingPoint::getY)).orElseThrow(NoSuchElementException::new).getY();

        int minX = Arrays.asList(points)
                .stream()
                .min(Comparator.comparing(MovingPoint::getX)).orElseThrow(NoSuchElementException::new).getX();


        int minY = Arrays.asList(points)
                .stream()
                .min(Comparator.comparing(MovingPoint::getY)).orElseThrow(NoSuchElementException::new).getY();



        List<String> lines = new ArrayList<>(minY+maxY+2);
        for (int y = minY-1; y < maxY+1; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = minX-1; x < maxX+1; x++) {
                if (contains(points, new Point(x, y))) {
                    line.append('#');
                }else{
                    line.append('.');
                }

            }
            lines.add(line.toString());
        }
        return lines;
    }


    private boolean contains(MovingPoint[] points, Point point) {
        for (MovingPoint mvp : points) {
            if (mvp.getPoint().equals(point)) {
                return true;
            }

        }
        return false;
    }

    private int countNeighbor(MovingPoint[] points, Point point, int distance){
        int count = 0;
        for (MovingPoint mvp : points) {
            if(point.distance(mvp.getPoint())<=distance){
                count++;
            }
        }
        return count;
    }
}
