package com.gmo.sae.aoc.day6;

import com.gmo.sae.aoc.FileHelper;

import java.io.IOException;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        try {
            List<String> lines = FileHelper.toLines("inputDay6_1.txt");

            Area area = new Area();

            for (String line:lines) {
                String[] lineArr = line.split(", ");
                area.addLocation(Integer.valueOf(lineArr[0]), Integer.valueOf(lineArr[1]));
            }

            Location bestLocation = area.getBestLocation();

            System.out.print(bestLocation.getId() + ", size=" + bestLocation.getControlledFields().size());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
