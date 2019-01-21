package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[][] testingArray = createMatrix();
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }
        System.out.println("Average: " + calculateAverage(testingArray));
    }

    private static int[][] createMatrix() {
        Random random = new Random();
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    private static double calculateAverage(int[][] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum / (array.length * array[0].length);
    }
}
