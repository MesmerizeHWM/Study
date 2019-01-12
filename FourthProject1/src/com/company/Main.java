package com.company;

import java.util.Scanner;

public class Main {

    private static int H = 24;
    private static int M = 60;
    private static int S = 60;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество суток:");
        int value = scanner.nextInt();

        int hours = H * value;
        int minutes = H * M * value;
        int seconds = H * M * S * value;

        System.out.printf("В %d сутках: %d часов, %d минут и %d секунд", value, hours, minutes, seconds);

    }
}
