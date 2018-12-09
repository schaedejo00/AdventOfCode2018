package com.gmo.sae.aoc.day7;

import com.gmo.sae.aoc.IdItem;

import java.util.LinkedList;
import java.util.List;

public class Node implements IdItem, Comparable<IdItem> {

    private String id;
    private List<Node> predecessors;
    private List<Node> successors;

    private boolean done = false;


    public Node(String id){
        this.id = id;
        predecessors = new LinkedList<>();
        successors = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Node> getPredecessors() {
        return predecessors;
    }

    public List<Node> getSuccessors() {
        return successors;
    }

    public void addSuccessor(Node node){
        if(!successors.contains(node)) {
            successors.add(node);
        }
        if(!node.getPredecessors().contains(this)){
            node.addPredecessor(this);
        }
    }

    public void addPredecessor(Node node) {
        if(!predecessors.contains(node)) {
            predecessors.add(node);
        }
        if(!node.getSuccessors().contains(this)){
            node.addSuccessor(this);
        }
    }

    public void removePredecessor(Node node){
        if(predecessors.contains(node)){
            predecessors.remove(node);
            if(node.getSuccessors().contains(this)){
                node.removeSuccessor(this);
            }
        }
    }

    public void removeSuccessor(Node node) {
        if(successors.contains(node)){
            successors.remove(node);
            if(node.getPredecessors().contains(this)){
                node.removePredecessor(this);
            }
        }
    }

    @Override
    public int compareTo(IdItem o) {
        return this.getId().compareTo(o.getId());
    }

    public String toString(){
        return id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
