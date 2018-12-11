package com.gmo.sae.aoc.day6;

import com.gmo.sae.aoc.ArrayHelper;
import com.gmo.sae.aoc.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * totally confused solution?!?!
 */
public class Area {

    private List<Location> locationList;

    public Area(){
        locationList = new LinkedList<>();
    }

    public void addLocation(int x, int y){
        locationList.add(Location.createLocation(x, y));
    }


    public Integer[][] getDistanceArray(){
        int minX = getMinX();
        int maxX = getMaxX();
        int minY = getMinY();
        int maxY = getMaxY();
        Integer[][] area;

        area = new Integer[maxX-minX+1][maxY-minY+1];
        for (int x = minX; x < maxX+1; x++) {
            for (int y = minY; y < maxY+1; y++) {
                int distance = 0;
                for (Location loc:locationList) {
                    distance = distance + loc.getPoint().distance(x,y);
                }

                area[x][y] = distance;
            }
        }
        new ArrayHelper<Integer>().print(area);
        return area;
    }

    private void assignAllCoordinates(){

        int minX = getMinX();
        int maxX = getMaxX();
        int minY = getMinY();
        int maxY = getMaxY();
        Location[][] area;

        area = new Location[maxX-minX+1][maxY-minY+1];
        for (int x = minX; x < maxX+1; x++) {
            for (int y = minY; y < maxY+1; y++) {
                Location loc = getNearestLocation(x, y);

                if (loc == null){
                    area[x][y] = null;
                }else {
                    int distance = (int)loc.getPoint().distance(x,y);
                    loc.addControlledFields(new Point(x, y));
                    if(distance!=0){
                        area[x][y] = loc;
                    }
                }
            }
        }
        new ArrayHelper<Location>().print(area);

    }

    public Location getBestLocation(){
        assignAllCoordinates();
        Location bestLocation = null;
        int largestArea = 0;
        int minX = getMinX();
        int maxX = getMaxX();
        int minY = getMinY();
        int maxY = getMaxY();
        for (Location location:locationList) {
            if (location.hasControlledFieldsAtBoarder(minX, maxX, minY, maxY)){
                continue;
            }

            if (location.getControlledFields().size() > largestArea){
                bestLocation=location;
                largestArea=location.getControlledFields().size();
            }
        }

        return bestLocation;
    }


    private Location getNearestLocation(int x, int y){
        locationList.sort(new LocationDistanceComparator(x,y));
        Location bestLocation = locationList.get(0);
        if(bestLocation.getPoint().distance(x, y) != locationList.get(1).getPoint().distance(x, y)){
            return bestLocation;
        }
        return null;
    }


    private int getMinX(){
        int res = 0;
        return res;
    }

    private int getMaxX(){
        int res = 0;
        for (Location loc:locationList) {
            if (res < loc.getPoint().getX()){
                res = (int)loc.getPoint().getX();
            }
        }
        return res+1;
    }

    private int getMinY(){
        int res = 0;
        return res;
    }

    private int getMaxY(){
        int res = 0;
        for (Location loc:locationList) {
            if (res < loc.getPoint().getY()){
                res = (int)loc.getPoint().getY();
            }
        }
        return res+1;
    }


}
