package com.company;

import java.util.Random;

public class Main {

    public static int[] arr = new int[10];

    public static void main(String[] args) {
        fillArray();
        printArray(arr);
    }

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
    }

    public static void printArray(int[] array) {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Array size: " + array.length);
    }
}
