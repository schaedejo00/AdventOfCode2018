package com.gmo.sae.aoc.day5;

import com.gmo.sae.aoc.FileHelper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {
        try {

            String polymer = FileHelper.getLine("inputDay5_1.txt", 0);

            List<Character> polymerList
                    = polymer.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
            System.out.println(polymerList);

            System.out.println("polymer unit count=" + polymerList.size());


            polymerList = reducePolymer(polymerList);

            System.out.println(polymerList);

            System.out.println("polymer unit count=" + polymerList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUpperCaseVersion(char char1, char char2){
        return Character.isUpperCase(char1) != Character.isUpperCase(char2)
                && Character.toLowerCase(char1) == Character.toLowerCase(char2);
    }

    public static List<Character> reducePolymer(List<Character> line){
        boolean reduced = true;
        while(reduced){
            reduced = false;
            for (int i = 0; i < line.size()-1; i++) {
                if(isUpperCaseVersion(line.get(i), line.get(i+1))){
                    line.remove(i+1);
                    line.remove(i);
                    reduced = true;
                    i=Math.max(0,i-2);
                }
            }
        }
        return  line;
    }




}
