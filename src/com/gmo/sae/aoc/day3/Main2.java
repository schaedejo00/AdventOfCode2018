package com.gmo.sae.aoc.day3;

import com.gmo.sae.aoc.FileHelper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        try {
            List<String> lines = FileHelper.toLines("inputDay3_1.txt");


            Claim[] claims = new Claim[lines.size()];
            Iterator<String> it = lines.iterator();
            int k = 0;
            while (it.hasNext()) {
                claims[k] = new Claim(it.next());
                k++;
            }

            Claim[][] fabric = new Claim[1000][1000];

            for (Claim claim : claims) {
                fabric = claim.apply(fabric);
            }

            for (Claim claim:claims) {
                if(claim.isValid()){
                    System.out.println(claim);
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
