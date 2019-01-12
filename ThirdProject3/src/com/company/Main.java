package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 10 - i;
            System.out.println(i + 1 + " элемент массива равен " + arr[i]);
        }
    }
}
