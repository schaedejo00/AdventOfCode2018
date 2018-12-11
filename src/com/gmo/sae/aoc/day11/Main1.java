package com.gmo.sae.aoc.day11;

import com.gmo.sae.aoc.FileHelper;
import com.gmo.sae.aoc.day10.MovingPoint;
import com.gmo.sae.aoc.day10.MovingPointFactory;
import com.gmo.sae.aoc.day10.Visualizer;

import java.io.IOException;
import java.util.List;

public class Main1 {


    public static void main(String[] args) {

        try {
            List<String> lines = FileHelper.toLines("inputDay11_1.txt");

            //PowerCell pc = new PowerCell(217,196,39);
            //System.out.print(pc.getPowerLevel());

            PowerGrid grid = new PowerGrid(300,300, 7139);

            System.out.println(grid.greatestPower());


        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }
}
