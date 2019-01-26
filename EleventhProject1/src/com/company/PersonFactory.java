package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonFactory {

    private static final String[] firstNameCollection = {"Jack", "Tom", "Willie", "Ann", "John", "Ashley"};
    private static final String[] lastNameCollection = {"Downie", "Marley", "Newman", "Legend", "Harris", "Black"};
    private static Random random = new Random();

    public static Person[] createPerson(int count) {
        Person[] persons = new Person[count];
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            persons[i] = new Person(firstNameCollection[random.nextInt(6)], lastNameCollection[random.nextInt(6)]);
            persons[i].setAge(random.nextInt(120) + 1);
            if (persons[i].getAge() < 10) {
                persons[i].setWeight(random.nextInt(5) + 7 + 2 * persons[i].getAge() + random.nextInt(100) / 100.0);
                persons[i].setHeight(random.nextInt(5) + 73 + (random.nextInt(3) + 5) * persons[i].getAge());
            } else if (persons[i].getAge() < 40) {
                persons[i].setWeight(random.nextInt(50) + 48 + random.nextInt(100) / 100.0);
                persons[i].setHeight((int)persons[i].getWeight() + 90 + random.nextInt(20));
            } else {
                persons[i].setWeight(random.nextInt(40) + 48 + random.nextInt(100) / 100.0);
                persons[i].setHeight((int)persons[i].getWeight() + 90 + random.nextInt(20));
            }
            System.out.println(persons[i]);
        }
        return persons;
    }
}
