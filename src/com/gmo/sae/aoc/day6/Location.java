package com.gmo.sae.aoc.day6;

import com.gmo.sae.aoc.Point;

import java.util.LinkedList;
import java.util.List;

public class Location {

    private com.gmo.sae.aoc.Point point;
    private int id;

    private static int lastId = 0;

    private List<com.gmo.sae.aoc.Point> controlledFields;

    public com.gmo.sae.aoc.Point getPoint() {
        return point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<com.gmo.sae.aoc.Point> getControlledFields() {
        return controlledFields;
    }

    public void addControlledFields(com.gmo.sae.aoc.Point controlledField) {
        this.controlledFields.add(controlledField);
    }

    private Location(int id, int x, int y) {
        this.id = id;
        reset();
        point = new com.gmo.sae.aoc.Point(x, y);
    }

    public static Location createLocation(int x, int y) {
        lastId = lastId + 1;
        return new Location(lastId, x, y);
    }

    public void reset() {
        controlledFields = new LinkedList<>();
    }

    public boolean hasControlledFieldsAtBoarder(int minX, int maxX, int minY, int maxY) {
        for (Point point : controlledFields) {
            if (point.getX() <= minX || point.getX() >= maxX || point.getY() <= minY || point.getY() >= maxY){
                return true;
            }
        }
        return false;
    }


    public String toString(){
        return ""+id;
    }
}
