package com.gmo.sae.aoc.day1;

import java.util.*;

public class Main2 {

    public static void main(String[] args){

        int sum=0;
        Map<Integer, Integer> results = new TreeMap<>();

        int i = 0;
        while(!results.containsKey(sum)) {
            results.put(sum, sum);
            sum=sum+Integer.valueOf(args[i]);
            i = (i+1)%args.length;
        }

        System.out.println("first frequency reached twice:" + sum);


    }


}
