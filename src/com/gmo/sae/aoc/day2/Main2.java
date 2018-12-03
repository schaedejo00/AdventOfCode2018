package com.gmo.sae.aoc.day2;

import java.util.*;

public class Main2 {

    public static void main(String[] args){

        List<String> ids = Arrays.asList(args);

        ids.sort(String::compareTo);

        for (int i = 0; i < ids.size(); i++) {
            char[] current = ids.get(i).toCharArray();

            for (int j = 0; j < ids.size(); j++) {

                if(i==j){
                    continue;
                }

                char[] other = ids.get(j).toCharArray();
                if (differsByOne(current, other)){
                    System.out.print(commonChars(current, other));
                    return;
                }
            }
        }
    }

    private static boolean differsByOne(char[] first, char[] second){
        int diff = 0;
        for (int i = 0; i < first.length; i++) {
            if(first[i] != second[i]){
                diff++;
            }

            if(diff>1){
                return false;
            }
        }
        return true;
    }



    private static String commonChars(char[] first, char[] second){
        StringBuilder common = new StringBuilder();
        for (int i = 0; i < first.length; i++) {
            if(first[i] == second[i]){
                common.append(first[i]);
            }
        }

        return common.toString();
    }


}
