package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] testingArray = {{1, 2, 3},{0, 2, 1}};
        int number = 9;
        multiplyMatrix(testingArray, number);
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }

    }

    private static void multiplyMatrix (int[][] array, int number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] *= number;
            }
        }
    }
}
