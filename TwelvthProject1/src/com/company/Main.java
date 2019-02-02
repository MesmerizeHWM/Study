package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	    Person person = new Person("Ivanov", "Ivan", "Ivanovich", LocalDate.of(1989, 05, 12));

        System.out.println(person.getFullName());
        System.out.println(person.getShortName());
        System.out.println(person.getAge());
    }
}
