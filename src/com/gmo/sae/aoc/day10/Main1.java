package com.gmo.sae.aoc.day10;

import com.gmo.sae.aoc.FileHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {

        try {
            List<String> lines = FileHelper.toLines("inputDay10_1.txt");

            MovingPoint[] points = MovingPointFactory.create(lines);


            Visualizer vis = new Visualizer();

            int seconds = 0;
            for (int i = 0; i < 50000; i++) {
                seconds++;
                List<String> strings = vis.visualize(points);
                if(strings != null){
                    for (String line:strings) {
                        System.out.println(line);
                    }
                    System.out.println("---------------" + seconds);
                }

            }


        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }





}
