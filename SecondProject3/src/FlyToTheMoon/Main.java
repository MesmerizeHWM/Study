package FlyToTheMoon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваш вес:");
        double weight = scanner.nextDouble();

        System.out.println("Ваш вес на луне составит примерно " + (weight / 100 * 17) + " кг");
    }
}
