package com.gmo.sae.aoc;

import java.util.List;

public class ListHelper{

    public static List<?> removeAllEquals(List<?> list, Object obj){

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(obj)){
                list.remove(i);
                i=Math.max(0, i-1);
            }
        }
        return list;

    }
}
