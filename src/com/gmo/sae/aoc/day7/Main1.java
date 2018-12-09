package com.gmo.sae.aoc.day7;

import com.gmo.sae.aoc.FileHelper;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        try {
            List<String> lines = FileHelper.toLines("inputDay7_2.txt");

            Graph graph = new Graph();

            for (String line:lines) {
                String[] relations = line.split(" ");

                Node nodeBefore = graph.getNodeById(relations[1]);
                Node nodeAfter = graph.getNodeById(relations[7]);

                nodeBefore.addSuccessor(nodeAfter);
            }

            //System.out.println(graph.getNodes());

            List<Node> executionOrder = graph.determineExecutionOrder();
            for (Node node:executionOrder) {
                System.out.print(node.getId());
            }

            System.out.println();
            System.out.println(new Scheduler(5).performTasks(executionOrder));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
