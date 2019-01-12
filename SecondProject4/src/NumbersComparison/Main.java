package NumbersComparison;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        double firstNumber = scanner.nextDouble();

        System.out.println("Введите второе число: ");
        double secondNumber = scanner.nextDouble();

        if (firstNumber > secondNumber) {
            System.out.println("Число " + firstNumber + " больше");
        }
        else if (firstNumber < secondNumber) {
            System.out.println("Число " + secondNumber + " больше");
        }
        else {
            System.out.println("Числа равны");
        }
    }
}
