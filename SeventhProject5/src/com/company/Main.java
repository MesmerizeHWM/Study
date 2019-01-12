package com.company;

public class Main {

    public static void main(String[] args) {
	    int firstNumber = 10;
	    int secondNumber = 28;
        System.out.print("firstNumber: " + firstNumber);
        System.out.println("   secondNumber: " + secondNumber);
        firstNumber += secondNumber;
        secondNumber = firstNumber - secondNumber;
        firstNumber = firstNumber - secondNumber;
        System.out.println("Numbers after swap:");
        System.out.print("firstNumber: " + firstNumber);
        System.out.println("   secondNumber: " + secondNumber);
    }
}
