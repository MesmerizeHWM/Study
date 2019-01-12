package com.company;

public class Main {

    public static void main(String[] args) {
        String a = "01234567891";
        if (isNumber(a)) {
            System.out.println("Только одни цифры");
        } else {
            System.out.println("Печалька");
        }
    }

    private static boolean isNumber(String a) {
        boolean isNumber = true;
        for (int i = 0; i < a.length(); i++) {
            if (a.codePointAt(i) < 48 || a.codePointAt(i) > 57) {
                isNumber = false;
                break;
            }
        }
        return isNumber;
    }
}

