package com.company;

import java.util.Locale;

import static java.lang.String.format;

public class Main {

    public static void main(String[] args) {
	    Fruit redApple = new Fruit(Fruit.Type.APPLE, Fruit.Color.RED, 270, 19.99);
        Fruit greenApple = new Fruit(Fruit.Type.APPLE, Fruit.Color.GREEN, 168, 14.99);
        Fruit lemon = new Fruit(Fruit.Type.LEMON, Fruit.Color.YELLOW, 200, 32.79);
        Fruit banana = new Fruit(Fruit.Type.BANANA, Fruit.Color.YELLOW, 198, 17.99);

        Fruit[] fruits = {redApple, greenApple, lemon, banana};

        double sum = 0;
        for (int i = 0; i < fruits.length; i++) {
            sum += fruits[i].countPrice();
        }

        System.out.println("Сумма чека: " + format(Locale.US, "%.2f", sum));
    }
}
