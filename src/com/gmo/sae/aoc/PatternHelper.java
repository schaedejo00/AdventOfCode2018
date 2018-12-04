package com.gmo.sae.aoc;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternHelper {

    public static List<String> matches(String txt, String regex){
        List<String> list = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);

        while (matcher.find()) {
            list.add(matcher.group());
        }

        return list;
    }

    public static String getFirstMatch(String txt, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
}
