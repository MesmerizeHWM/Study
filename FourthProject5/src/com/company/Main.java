package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        text = text.toLowerCase();
        int checker = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == text.charAt(text.length() - 1 - i)) {
                checker++;
            }
        }
        if (checker == text.length()) {
            System.out.println("Введенный текст является полиндромом");
        } else {
            System.out.println("Не полиндром");
        }
    }
}
