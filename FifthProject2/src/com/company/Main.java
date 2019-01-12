package com.company;

import java.util.Scanner;

public class Main {

    public static double money;
    public static double years;
    public static final double monthInYear = 12;

    public static void main(String[] args) {
        inputData();
        calculateResult();
        System.out.printf("Сумма вашего вклада через %.0f год(а)(лет) составит %.2f грн", years, money);
    }

    public static void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму, которую вы хотите положить на депозит:");
        money = scanner.nextDouble();
        System.out.println("На сколько лет вы хотите открыть депозит:");
        years = scanner.nextDouble();
    }

    public static void calculateResult() {
        for (int i = 0; i < (monthInYear * years); i++) {
            money += money * 0.015;
        }
    }
}
