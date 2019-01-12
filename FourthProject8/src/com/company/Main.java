package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    // This class will print only the last element, when there is more than one element with
    // maximum number of appearance

    public static void main(String[] args) {

        int maxCounter = 0;
        int maxCounterNum = 0;
        int[] arr = new int[20];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(5);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                }
            }
            if (maxCounter <= counter) {
                maxCounter = counter;
                maxCounterNum = arr[i];
            }

        }
        System.out.println(maxCounterNum);
    }
}
