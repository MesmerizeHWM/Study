package com.company;

public class Main {

    // уравнение x * x + 3 * x + 2 = 0
    public static void main(String[] args) {
        int a = 1;
        int b = 3;
        int c = 2;
        double discriminant = getDiscriminant(a, b, c);
        if (discriminant > 0) {
            double x1 = (- b - Math.sqrt(discriminant)) / (2 * a);
            double x2 = (- b + Math.sqrt(discriminant)) / (2 * a);
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (discriminant == 0) {
            double x = - b / (2 * a);
            System.out.println("x = " + x);
        } else {
            System.out.println("Корней нет");
        }
    }

    public static double getDiscriminant(int a, int b, int c) {
        double d = b * b - 4 * a * c;
        return d;
    }
}
