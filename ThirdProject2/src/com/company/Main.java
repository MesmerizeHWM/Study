package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr)); // output of array

        int min = arr[0];
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println("Все числа равны: " + arr[0]);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]){
                    min = arr[i];
                }
            }
        }
        System.out.println("Минимальное число: " + min);
    }
}
