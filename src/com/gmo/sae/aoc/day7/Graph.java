package com.gmo.sae.aoc.day7;

import com.gmo.sae.aoc.IdComparator;

import java.util.*;

public class Graph {

    private Set<Node> nodes;

    public Graph(){
        nodes = new TreeSet<>();
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public Node getNodeById(String id){

        for (Node node:nodes) {
            if(node.getId().equals(id)){
                return node;
            }
        }
        Node newNode = new Node(id);
        nodes.add(newNode);
        return newNode;
    }


    public List<Node> determineExecutionOrder(){
        List<Node> toReturn = new LinkedList<>();

        TreeSet<Node> possibleSuccessors = new TreeSet<>();

        //determine all Starting nodes
        for (Node node:nodes) {
            if(node.getPredecessors().size() == 0){
                possibleSuccessors.add(node);
            }
        }

        //Comparator comparator = new IdComparator();
        while(toReturn.size() < nodes.size()){
            //possibleSuccessors.sort(comparator);

            Node nextNode = possibleSuccessors.pollFirst();
            toReturn.add(nextNode);

            for (Node node:nextNode.getSuccessors()) {
                if(!toReturn.contains(node) && toReturn.containsAll(node.getPredecessors())) {
                    possibleSuccessors.add(node);
                }
            }
        }

        return toReturn;
    }


}
