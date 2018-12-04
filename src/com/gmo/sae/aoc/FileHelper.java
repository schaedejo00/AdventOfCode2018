package com.gmo.sae.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileHelper {


    public static List<String> toLines(String fileName) throws IOException {

        List<String> lines = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        return lines;
    }


}
