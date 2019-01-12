package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное число:");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            sum += ((double)1 / i);
        }
        System.out.println("Ответ: " + sum);
    }
}
