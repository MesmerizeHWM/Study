package com.company;

import java.util.Scanner;

public class Main {

    public static int number = 12000;

    public static void main(String[] args) {
	long timeStart = System.currentTimeMillis();
	findNumber(number);
	long timeEnd = System.currentTimeMillis();
	long diff = timeEnd - timeStart;
	System.out.println("Time spent: " + (diff / 1000) + " seconds");
    }

    public static void findNumber(int n) {
        int counter = 0;
        for (int i = 2; i <= 2147483647; i++) {
            if (isPrime(i)) {
                counter++;
            }
            if (counter == n) {
                System.out.println("Your prime number is " + i);
                break;
            }
        }
    }

    public static boolean isPrime(int i) {
        boolean isPrime = false;
        int tmp = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                tmp++;
            }
            if (tmp > 2) {
                break;
            }
        }
        if (tmp == 2) {
            isPrime = true;
        }
        return isPrime;
    }
}
