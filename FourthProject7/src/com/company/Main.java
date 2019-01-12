package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int counter = 1;
        int maxCounter = 1;
        Random random = new Random();
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(3) + 1;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                counter++;
                System.out.println(counter);
                if (maxCounter <= counter) {
                    maxCounter = counter;
                }
            } else {
                counter = 1;
            }
        }

        System.out.println("Наибольшая последовательность одинаковых элементов равна = " + maxCounter);
    }
}
