package com.company;

public class Main {

    public static void main(String[] args) {
        countTriangles();
    }

    public static double getP(int a, int b, int c) {
        double p = (a + b + c) / (double) 2;
        return p;
    }

    public static double getS(double p, int a, int b, int c) {
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

    public static void countTriangles() {
        int counter = 0;
        for (int a = 1; a < 201; a++) {
            for (int b = 1; b < 201; b++) {
                for (int c = 1; c < a + b; c++) {
                    if (b >= a + c || a >= b + c) {
                        continue;
                    }
                    double s = getS(getP(a, b, c), a, b, c);
                    if (s <= 100) {
                        counter++;
                    }
                }
            }
        }
        System.out.println("Количество треугольников: " + counter);
        // * (опционально) Сделать задание так чтобы не было повторяющихся треугольников, например (3,4,5) и (5,3,4) - повторяющиеся.
        System.out.println("Количество не повторяющихся треугольников: " + (counter / 6));
    }
}
