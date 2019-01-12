package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[] arr = new int[10];

    public static void main(String[] args) {
        fillArray();
        countGreaterElements(arr);
        countEvenElements(arr);
        countElementsGreaterThenAverage(arr);
    }

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println("Array: " + Arrays.toString(arr));
    }

    public static void countGreaterElements(int[] array) {
        int counter = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                counter++;
            }
        }
        System.out.println("Number of elements greater then nearest left element: " + counter);
    }

    public static void countEvenElements(int[] array) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.println("Number of even elements: " + counter);
    }

    public static void countElementsGreaterThenAverage(int[] array) {
        int counter = 0;
        double average = 0;
        for (int i = 0; i < array.length; i++) {
            average += array[i];
        }
        average /= (double)array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < average) {
                counter++;
            }
        }
        System.out.println("Average: " + average);
        System.out.println("Number of elements smaller then average: " + counter);
    }
}
