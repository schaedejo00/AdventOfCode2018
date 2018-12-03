package com.gmo.sae.aoc.day1;

public class Main1 {

    public static void main(String[] args){

        int sum=0;
        for (String frequency: args) {
            sum=sum+Integer.valueOf(frequency);
            System.out.println("value="+ frequency + ", sum=" + sum);

        }


    }

}
