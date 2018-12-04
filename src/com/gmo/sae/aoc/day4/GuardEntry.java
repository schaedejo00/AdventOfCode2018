package com.gmo.sae.aoc.day4;

import com.gmo.sae.aoc.PatternHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GuardEntry implements Comparable<GuardEntry>{

    private Guard guard = null;
    private Calendar calendar;
    private GuardEvent event;


    public GuardEntry(String eventString) {
        /*[1518-06-12 00:00] Guard #3359 begins shift
            [1518-10-08 00:19] wakes up
            [1518-07-21 00:53] wakes up
            [1518-06-07 00:26] falls asleep*/
        String[] eventArray = eventString.split(" ");

        String[] date = eventArray[0].substring(1).split("-");
        int year=Integer.valueOf(date[0]);
        int month=Integer.valueOf(date[1])-1;
        int day=Integer.valueOf(date[2]);

        String[] time = eventArray[1].substring(0, eventArray[1].length()-1).split(":");
        int hour=Integer.valueOf(time[0]);
        int minute=Integer.valueOf(time[1]);

        calendar = new GregorianCalendar(year, month, day, hour, minute);

        setEvent(eventArray[2]);
        if (event == GuardEvent.Guard) {
            String tmp = eventArray[3].substring(1);
            guard = Guard.getGuardById(Integer.valueOf(tmp));
        }
    }

    public Guard getGuard() {
        return guard;
    }

    public void setGuard(int guardId) {
        guard =  Guard.getGuardById(guardId);
    }

    public void setGuard(Guard guard) {
        this.guard =  guard;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public GuardEvent getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = GuardEvent.valueOf(event);
    }

    public String toString(){
        return "[" + calendar.getTime() + "] " + event.toString() + (guard!=null?" #" + String.valueOf(guard.getId()):"");
    }

    @Override
    public int compareTo(GuardEntry o) {
        return getCalendar().compareTo(o.getCalendar());
    }
}
