package com.company;

public class Main {

    public static void main(String[] args) {
        Person[] array = PersonFactory.createPerson(100);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
