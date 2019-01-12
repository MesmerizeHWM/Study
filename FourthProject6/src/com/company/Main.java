package com.company;

        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        int number = scanner.nextInt();
        if (number < 0) {
            number = number * (-1);
        }

        String stringToNumber = String.valueOf(number);
        int length = stringToNumber.length();

        for ( int i = 0; i < length; i++) {
            sum += (number % 10);
            if (i != length - 1) {
                number = number / 10;
            }
        }

        System.out.println("Сумма цифр = " + sum);
    }
}
