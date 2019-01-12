package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        System.out.println("Массив: " + Arrays.toString(arr));

        int max = arr[0];
        for (int i = 0; i < size; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Максимальный элемент равен: " + max);

        for (int i = 0; i < size; i++) {
            if (max == arr[i]) {
                System.out.println("Индекс максимального элемента: " + i);
            }
        }
    }
}