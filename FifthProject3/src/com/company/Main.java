package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("HelloWorld");
            } else if (i % 5 == 0) {
                System.out.print("Hello");
            } else if (i % 3 == 0) {
                System.out.print("World");
            } else {
                System.out.print(i);
            }
            if (i != 100) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
        }
    }
}


