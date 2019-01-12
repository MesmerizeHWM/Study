package com.company;

public class Main {

    private static int numberOfPairs = 11;

    public static void main(String[] args) {
        int tmpNumber = 1;
        int count = 0;
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (isPrime(i)) {
                if (i - tmpNumber == 2) {
                    count++;
                    System.out.println(tmpNumber + " and " + i);
                }
                tmpNumber = i;
            }
            if (count == numberOfPairs) {
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
