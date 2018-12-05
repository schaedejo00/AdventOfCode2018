package com.gmo.sae.aoc.day5;

import com.gmo.sae.aoc.FileHelper;
import com.gmo.sae.aoc.ListHelper;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        try {

            String polymer = FileHelper.getLine("inputDay5_1.txt", 0);

            List<Character> polymerList
                    = polymer.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            polymerList = reducePolymer(polymerList);
            List<Character> polymerListClone = null;
            char[] alphabet = generateUpperCaseAlphabet();

            int shortest = Integer.MAX_VALUE;
            for (char character: alphabet) {
                polymerListClone = new LinkedList<>(polymerList);
                ListHelper.removeAllEquals(polymerListClone, character);
                ListHelper.removeAllEquals(polymerListClone, Character.toLowerCase(character));
                polymerListClone = reducePolymer(polymerListClone);

                if(polymerListClone.size() < shortest){
                    shortest = polymerListClone.size();
                }
                System.out.println(polymerListClone);
                System.out.println("polymer unit count=" + shortest);
            }




            System.out.println(polymerListClone);
            System.out.println("polymer unit count=" + shortest);
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


    /**
     * Generates an array of all upper case ASCII chars
     * Index of first char (A) = 65
     *  Index of last char (Z) = 90
     * See https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html for details.
     * @return array of ASCII chars
     */
    public static char[] generateUpperCaseAlphabet(){
        return generateAlphabet(65, 90);
    }


    /**
     * Generates an array of all possible ASCII chars with an int value
     * between firstCharValue und lastCharValue
     * @param firstCharValue int value of the first char of the alphabet
     * @param lastCharValue int value of the last char of the alphabet
     * @return alphabet
     */
    private static char[] generateAlphabet(int firstCharValue, int lastCharValue){

        char[] alphabet = new char[lastCharValue- firstCharValue+1];

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char) (i + firstCharValue);
        }

        return alphabet;
    }



}
