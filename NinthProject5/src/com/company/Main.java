package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[][] testingArray = createMatrix();
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }
        System.out.println("");

        swapLines(testingArray, 0, 1);
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }
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

    private static void swapLines(int[][] array, int index1, int index2) {
        int[] tmpArray = array[index1];
        array[index1] = array[index2];
        array[index2] = tmpArray;
    }
}
