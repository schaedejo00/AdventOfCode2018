package com.gmo.sae.aoc.day6;

import com.gmo.sae.aoc.FileHelper;

import java.io.IOException;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        try {
            List<String> lines = FileHelper.toLines("inputDay6_2.txt");

            Area area = new Area();

            for (String line:lines) {
                String[] lineArr = line.split(", ");
                area.addLocation(Integer.valueOf(lineArr[0]), Integer.valueOf(lineArr[1]));
            }

            Integer[][] distanceArray = area.getDistanceArray();

            int countFields = 0;
            for (Integer[] distanceRow:distanceArray) {
                for (Integer distance:distanceRow) {
                    if(distance < 10000){
                        countFields++;
                    }
                }
            }

            System.out.print(countFields);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
