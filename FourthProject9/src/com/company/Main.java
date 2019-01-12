package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int maxIndex = 0;
        int minIndex = 0;
        int sum = 0;

        Random random = new Random();
        int[] arr = new int[20];

        //заполнение массива числами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(30) + 1;
        }
        System.out.println(Arrays.toString(arr));

        int min = arr[0];
        int max = arr[0];

        //нахождение максимальных и минимальных значений и их индексов
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);

        //выявление суммы элементов между макс и мин значением
        if (maxIndex > minIndex) {
            for (int i = minIndex + 1; i < maxIndex; i++) {
                sum += arr[i];
            }
        } else {
            for (int i = maxIndex + 1; i < minIndex; i++) {
                sum += arr[i];
            }
        }
        System.out.println("Sum = " + sum);
    }
}
