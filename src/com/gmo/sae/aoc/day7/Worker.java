package com.gmo.sae.aoc.day7;

public class Worker {

    private Node node;
    private int currentWork;
    private int targetWork;


    public void setTask(Node node) {
        this.node = node;
        currentWork = 0;
        if (node != null) {
            targetWork = 60 +(int) node.getId().toCharArray()[0] - 64;
        } else {
            targetWork = 0;
        }
    }

    public Node getTask() {
        return node;
    }
    public boolean isDone(){
        return node == null || currentWork >= targetWork;
    }




    public void tick() {
        currentWork++;
        if (node != null && currentWork >= targetWork) {
            node.setDone(true);
        }
    }

    public String toString() {
        return node == null ? "-" : node.getId() + "[" + currentWork + ", " + targetWork + "]";
    }

}
