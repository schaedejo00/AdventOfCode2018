package com.gmo.sae.aoc.day4;

import com.gmo.sae.aoc.FileHelper;

import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Main2 {


    public static void main(String[] args) {
        try {
            List<String> lines = FileHelper.toLines("inputDay4_1.txt");

            List<GuardEntry> guardEntries = new LinkedList<>();

            //Create List of guardEntries
            for (String line : lines) {
                GuardEntry entry = new GuardEntry(line);
                guardEntries.add(entry);
            }

            //Sort Entries
            guardEntries.sort(GuardEntry::compareTo);

            //Apply entries to all Guards
            Guard currentGuard = null;
            //int startHH = 0;
            int start = 0;
            for (GuardEntry entry : guardEntries) {
                switch (entry.getEvent()) {
                    case Guard:
                        currentGuard = entry.getGuard();
                        break;
                    case falls:
                        //startHH = entry.getCalendar().get(Calendar.HOUR);
                        start = entry.getCalendar().get(Calendar.MINUTE);
                        entry.setGuard(currentGuard);
                        break;
                    case wakes:
                        //int sleep = (entry.getCalendar().get(Calendar.HOUR) - startHH) * 60;
                        currentGuard.addSleepingTime(start, entry.getCalendar().get(Calendar.MINUTE));
                        entry.setGuard(currentGuard);
                        break;
                }
                System.out.println(entry);
            }

            Guard lazyGuard = Guard.getGuards().iterator().next();
            for (Guard guard : Guard.getGuards()) {
                if (guard.getSleepingMinutes()[guard.getFavoritSleepingMinute()] > lazyGuard.getSleepingMinutes()[lazyGuard.getFavoritSleepingMinute()]) {
                    lazyGuard = guard;
                }
            }

            System.out.println("Max GuardId=" + lazyGuard.getId() + ", favoriteMinute=" + lazyGuard.getFavoritSleepingMinute()
                    + ", hash=" + (lazyGuard.getId() * lazyGuard.getFavoritSleepingMinute()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
