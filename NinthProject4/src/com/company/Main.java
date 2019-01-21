package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[][] testingArray = createMatrix();
        for (int i = 0; i < testingArray.length; i++) {
            System.out.println(Arrays.toString(testingArray[i]));
        }

        int maxSumLine = 0;
        int maxSum = 0;
        for (int i = 0; i < testingArray[0].length; i++) {
            maxSum += testingArray[0][i];
        }
        for (int i = 0; i < testingArray.length; i++) {
            int tmpSum = 0;
            for (int j = 0; j < testingArray[i].length; j++) {
                tmpSum += testingArray[i][j];
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
                maxSumLine = i;
            }
        }
        System.out.println("Линия с максимальной суммой элементов: " + maxSumLine);
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
}
