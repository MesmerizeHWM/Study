package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int[] arr = new int[10];
    public static int number = 10;

    public static void main(String[] args) {
        fillArray();
        System.out.println("Multiplied array: " + Arrays.toString(getArrayMultipliedOnNumber(arr, number)));
    }

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println("Array: " + Arrays.toString(arr));
    }

    public static int[] getArrayMultipliedOnNumber(int[] array, int multiplier) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= multiplier;
        }
        return array;
    }
}
