package com.gmo.sae.aoc.day11;

import com.gmo.sae.aoc.day10.MovingPoint;

import java.util.*;

public class PowerGrid {

    private PowerCell[][] grid;
    private int serial;

    public PowerGrid(int dimX, int dimY, int serial) {
        grid = new PowerCell[dimX][dimY];
        this.serial = serial;

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                grid[x][y] = new PowerCell(x + 1, y + 1, serial);
            }
        }

        //System.out.println(toString());

    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                str.append(String.format("%5d", grid[x][y].getPowerLevel()));
            }
            str.append("\n");
        }
        return str.toString();
    }

    public Area greatestPower() {
        Area greatest = new Area(0, 0, 1, grid);
        for (int size = 1; size < 301; size++) {
            for (int y = 0; y < grid.length - size+1; y++) {
                for (int x = 0; x < grid[y].length - size+1; x++) {
                    Area area = new Area(x, y, size, grid);
                    if (area.getTotalPower() > greatest.getTotalPower()) {
                        greatest = area;
                        System.out.println(greatest);
                    }
                }
            }
        }

        /*PowerCell greatest = cells()
                .stream()
                .max(Comparator.comparing(PowerCell::getPowerLevel)).orElseThrow(NoSuchElementException::new);*/
        return greatest;
    }

    private List<PowerCell> cells() {
        List<PowerCell> toReturn = new LinkedList<>();
        for (PowerCell[] line : grid) {
            toReturn.addAll(Arrays.asList(line));
        }
        return toReturn;
    }


}
