package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("Числа от 100 до 200, кратные 17:");
        for (int i = 100; i < 200; i++) {
            if (i % 17 == 0) {
                System.out.println(i);
            }
        }
    }
}
