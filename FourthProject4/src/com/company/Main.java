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
        int[] arr1 = new int[size];

        for (int i = 0; i < size; i++) {
            arr1[i] = random.nextInt(100);
        }
        System.out.println("Массив: " + Arrays.toString(arr1));

        int[] arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr2[i] = arr1[size - 1 - i];
        }
        System.out.println("Массив после перестановок: " + Arrays.toString(arr2));
    }
}
