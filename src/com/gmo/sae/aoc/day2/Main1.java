package com.gmo.sae.aoc.day2;

import java.util.Map;
import java.util.TreeMap;

public class Main1 {

    public static void main(String[] args) {

        int twoCounter = 0;
        int threeCounter = 0;
        for (String current : args) {
            char[] snippet = current.toCharArray();

            Map<Character, Integer> charCounter = new TreeMap<>();
            for (char currentChar : snippet) {
                int count = 0;
                if (charCounter.containsKey(currentChar)) {
                    count = charCounter.get(currentChar);
                }
                count++;
                charCounter.put(currentChar, count);
            }

            if (charCounter.containsValue(2)) {
                twoCounter++;
            }
            if (charCounter.containsValue(3)) {
                threeCounter++;
            }

        }

        System.out.print("twoCounter=" + twoCounter + ", threeCounter=" + threeCounter + ", result=" + (twoCounter * threeCounter));


    }

}
