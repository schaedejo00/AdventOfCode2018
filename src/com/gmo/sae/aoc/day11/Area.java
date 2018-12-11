package com.gmo.sae.aoc.day11;

public class Area {
    private PowerCell topLeft;
    private int totalPower;
    private int size;

    public Area(int fromX, int fromY, int dim, PowerCell[][] grid) {

        totalPower = 0;
        topLeft = grid[fromX][fromY];
        this.size = dim;
        for (int y = fromY; y < fromY+dim; y++) {
            for (int x = fromX; x < fromX+dim; x++) {
                totalPower += grid[x][y].getPowerLevel();
            }
        }
    }

    public int getTotalPower() {
        return totalPower;
    }

    public PowerCell getTopLeft() {
        return topLeft;
    }

    public int getSize() {
        return size;
    }

    public String toString(){
        return topLeft.toString() + ", site=" + size;
    }
}
