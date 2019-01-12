package Triangle;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первый катет: ");
        double leg1 = scanner.nextDouble();

        System.out.println("Введите второй катет: ");
        double leg2 = scanner.nextDouble();

        System.out.println("Гипотенуза равна: " + Math.sqrt(leg1 *leg1 + leg2 * leg2));
    }
}
