package com.gmo.sae.aoc.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {

    private int id;
    private int leftPadding;
    private int topPadding;
    private int width;
    private int height;
    private boolean valid = true;

    public Claim(String config) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(config);

        int[] attr = new int[5];
        int i = 0;
        while (matcher.find()) {
            attr[i] = Integer.valueOf(matcher.group());
            i++;
        }
        id = attr[0];
        leftPadding = attr[1];
        topPadding = attr[2];
        width = attr[3];
        height = attr[4];

    }

    public int getId() {
        return id;
    }

    public int getLeftPadding() {
        return leftPadding;
    }

    public int getTopPadding() {
        return topPadding;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Claim[][] apply(Claim[][] fabric){
        for (int i = leftPadding; i < leftPadding + width; i++) {
            for (int j = topPadding; j < topPadding + height; j++) {
                if(fabric[i][j]!=null){
                    fabric[i][j].setValid(false);
                    this.setValid(false);
                }
                fabric[i][j] = this;
            }
        }
        return fabric;
    }

    public int[][] apply(int[][] fabric){
        for (int i = leftPadding; i < leftPadding + width; i++) {
            for (int j = topPadding; j < topPadding + height; j++) {
                fabric[i][j]=fabric[i][j]+1;
            }
        }
        return fabric;
    }

    public String toString() {
        //#1 @ 1,3: 4x4
        return "#" + id + " @ " + leftPadding + "," + topPadding + ": " + width + "x" + height;
    }


}
