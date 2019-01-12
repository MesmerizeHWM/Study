package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double mid = 0;
        int sum = 0;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
            sum += arr[i];
        }

        System.out.println("Массив: " + Arrays.toString(arr));
        mid = sum / (double) size;
        System.out.println("Среднее арифметическое равно " + mid);

        System.out.println("Числа больше среднего арифметического:");
        for (int i = 0; i < size; i++) {
            if (arr[i] > mid) {
                System.out.println(arr[i]);
            }
        }
    }
}
