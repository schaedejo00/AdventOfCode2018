package com.gmo.sae.aoc.day7;

import java.util.*;

public class Scheduler {

    private Worker[] workers;

    private int time;


    public Scheduler(int workerCount) {
        time = 0;
        workers = new Worker[workerCount];
        for (int i = 0; i < workerCount; i++) {
            workers[i] = new Worker();
        }
    }

    public int performTasks(List<Node> work) {
        List<Node> workDone = new LinkedList<>();

        TreeSet<Node> tasks = getAvailibleTasks(work);
        for (Worker worker : workers) {
            if (tasks.size() >0) {
                Node task = tasks.pollFirst();
                worker.setTask(task);
                work.remove(task);
            }
        }

        while (work.size() > 0 || isBusy()) {
            for (Worker worker : workers) {
                worker.tick();

            }
            for (Worker worker : workers) {
                if (worker.isDone() && work.size() > 0) {
                    if (worker.getTask() != null && !workDone.contains(worker.getTask())) {
                        workDone.add(worker.getTask());
                        worker.setTask(null);
                    }
                    tasks = getAvailibleTasks(work);
                    if (tasks.size() >0) {
                        Node task = tasks.pollFirst();
                        worker.setTask(task);
                        work.remove(task);
                    }
                }
            }


            time++;
            System.out.println(this.toString());
        }
        return time;
    }

    private boolean isBusy(){
        for (Worker worker:workers) {

            if(!worker.isDone()){
                return true;
            }

        }
        return false;

    }

    private TreeSet<Node> getAvailibleTasks(List<Node> work) {
        TreeSet<Node> availibleTasks = new TreeSet<>();
        for (Node potentialWork : work) {
            boolean predecessorsDone = true;
            for (Node pred : potentialWork.getPredecessors()) {
                if (!pred.isDone()) {
                    predecessorsDone = false;
                }

            }
            if (predecessorsDone) {
                availibleTasks.add(potentialWork);
            }
        }
        return availibleTasks;

    }

    public String toString() {
        String toReturn = "time=" + time + ", worker=(";
        for (Worker worker : workers) {
            toReturn = toReturn + worker.toString() + ", ";

        }
        toReturn = toReturn + ")";
        return toReturn;
    }
}
