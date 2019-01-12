package com.company;

import static java.lang.Character.*;
import static java.lang.String.format;

public class Main {

    public static void main(String[] args) {
        printNumberOfLuckyTickets();
    }

    public static void printNumberOfLuckyTickets() {
        int counter =0;
        for (int i = 000001; i <= 999999; i++) {
            int a = i / 100000;
            int b = i / 10000 % 10;
            int c = i / 1000 % 10;
            int d = i / 100 % 10;
            int e = i / 10 % 10;
            int f = i % 10;
            if (a + b + c == d + e + f) {
                counter++;
            }
        }
        System.out.println("Количество счастливых билетиков: " + counter);
    }
//    public static void main(String[] args) {
//        printNumberOfLuckyTickets();
//    }
//
//    private static void printNumberOfLuckyTickets() {
//        int counter = 0;
//        int[] arr1 = new int[3];
//        int[] arr2 = new int[3];
//        for (int i = 1; i < 1000000; i++) {
//            int sum1 = 0;
//            int sum2 = 0;
//            for (int j = 0; j < 6; j++) {
//                String a = String.format("%06d",i);
//                for (int k = 0; k < 3; k++) {
//                    if (j < 3) {
//                        sum1 += Character.getNumericValue(a.charAt(j));
//                    } else {
//                        sum2 += Character.getNumericValue(a.charAt(j));
//                    }
//                }
//            }
//            if (sum1 == sum2) {
//                counter++;
//            }
//        }
//        System.out.println("Количество счастливых билетиков: " + counter);
//    }
}
