package com.gmo.sae.aoc.day4;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Guard {

    private static Map<Integer, Guard> guards = new TreeMap<>();

    private int id;
    private int[] sleepingMinutes = new int[60];

    private Guard(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public static Guard getGuardById(int id){
        if(!guards.containsKey(id)){
            guards.put(id, new Guard(id));
        }
        return guards.get(id);
    }

    public void addSleepingTime(int start, int end){
        for (int i = start; i < end; i++) {
            sleepingMinutes[i]++;
        }
    }

    public int getTotalSleepingMinutes(){
        int sum = 0;
        for (int i = 0; i < sleepingMinutes.length; i++) {
            sum = sum + sleepingMinutes[i];
        }
        return sum;
    }

    public int getFavoritSleepingMinute(){
        int max = 0;
        int maxId = 0;
        for (int i = 0; i < sleepingMinutes.length; i++) {
            if(sleepingMinutes[i] > max){
                maxId = i;
                max = sleepingMinutes[i];
            }
        }
        return maxId;
    }

    public int[] getSleepingMinutes(){
        return this.sleepingMinutes;
    }

    public static Collection<Guard> getGuards(){
        return guards.values();
    }

    public static Guard getMostLazyGuard(){
        int maxSleepTime = 0;
        Guard maxSleeper = null;
        for (Guard guard:getGuards()) {
            if (guard.getTotalSleepingMinutes()>maxSleepTime){
                maxSleepTime = guard.getTotalSleepingMinutes();
                maxSleeper = guard;
            }
        }
        return maxSleeper;
    }
}
