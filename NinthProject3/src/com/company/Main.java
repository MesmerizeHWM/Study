package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] testingArray = createMatrix();
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }
        System.out.print("Введите число: ");
        int number = enterNumber();
        countNumberInArray(testingArray, number);
    }

    private static int[][] createMatrix() {
        Random random = new Random();
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        return number;
    }

    private static void countNumberInArray(int[][] array, int number) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == number) {
                    count++;
                }
            }
        }
        System.out.println("Count of number in array: " + count);
    }
}
