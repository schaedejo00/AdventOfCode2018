package com.gmo.sae.aoc.day10;

import com.gmo.sae.aoc.PatternHelper;
import com.gmo.sae.aoc.Point;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.LinkedList;
import java.util.List;

public class MovingPointFactory {

    public static MovingPoint create(String text){

        List<String> coordinates = PatternHelper.matches(text, "([-]{0,1}[0-9]+)");
        MovingPoint mp = new MovingPoint(new Point(Integer.valueOf(coordinates.get(0)),
                Integer.valueOf(coordinates.get(1))),
                new Velocity(Integer.valueOf(coordinates.get(2)), Integer.valueOf(coordinates.get(3))));
        return mp;
    }

    public static MovingPoint[] create(List<String> lines){
        MovingPoint[] points = new MovingPoint[lines.size()];

        int i =0;
        for (String line:lines) {
            points[i] = create(line);
            i++;
        }
        return points;
    }
}
