package com.company;

public class Main {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 00; i < 24; i++) {
            for (int j = 00; j < 60; j++) {
                if (i / 10 == j % 10 && i % 10 == j / 10) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
