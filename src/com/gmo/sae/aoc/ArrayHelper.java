package com.gmo.sae.aoc;

public class ArrayHelper<T> {

    public void print(T[] arr) {
        System.out.print("[");
        for (T element : arr) {
            if (element != null) {
                System.out.print(element.toString());
            }
            System.out.print(", ");
        }
        System.out.println("]");
    }

    public void print(T[][] arr) {
        System.out.print("[");
        for (T[] row : arr) {
            System.out.print("[");
            for (T element : row) {
                if (element != null) {
                    System.out.print(element.toString());
                }
                System.out.print(", ");
            }
            System.out.println("]");
        }
        System.out.print("]");
    }

}

