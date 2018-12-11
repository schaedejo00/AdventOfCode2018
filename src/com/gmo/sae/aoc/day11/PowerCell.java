package com.gmo.sae.aoc.day11;

import com.gmo.sae.aoc.Point;

public class PowerCell extends Point {

    private int powerLevel;

    public PowerCell(int x, int y, int serial) {
        super(x, y);
        powerLevel = getRackID() * getY();
        powerLevel+=serial;
        powerLevel*=getRackID();

        char[] powerDigits = String.valueOf(powerLevel).toCharArray();
        powerLevel = 0;
        if(powerDigits.length>2){
            powerLevel = Integer.valueOf(""+powerDigits[powerDigits.length-3]);
        }
        powerLevel-=5;

    }

    private int getRackID(){
        return getX()+10;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public String toString(){
        return String.valueOf("["+getX()+", "+getY()+"]="+powerLevel);
    }


}
