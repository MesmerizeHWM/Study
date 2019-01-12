package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static int[] arr = new int[10];

    public static void main(String[] args) {
        fillArray();
        createArrayX2(arr);
    }

    public static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(20);
        }
        System.out.println("Array: " + Arrays.toString(arr));
    }

    public static void createArrayX2(int[] array) {
        int[] arrayX2 = new int[array.length * 2];
        for (int i = 0; i < arrayX2.length; i++) {
            if (i < array.length) {
                arrayX2[i] = array[i];
            } else {
                arrayX2[i] = array[i - array.length];
            }
        }
        System.out.println("Array x 2: " + Arrays.toString(arrayX2));
    }
}
