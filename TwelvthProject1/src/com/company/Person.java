package com.company;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String lastName, firstName, middleName;
    private LocalDate dateOfBirth;

    public Person(String lastName, String firstName, String middleName, LocalDate dateOfBirth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public Person(String fullName) {
        try {
            String[] arr = fullName.split(" ");
            this.lastName = arr[0];
            this.firstName = arr[1];
            this.middleName = arr[2];
        } catch (Exception e) {
            System.out.println("Incorrect full name was entered");
        }
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public String getShortName() {
        return lastName + " " + firstName.charAt(0) + ". " + middleName.charAt(0) + ". ";
    }

    public int getAge() {
        Period p = Period.between(dateOfBirth, LocalDate.now());
        return p.getYears();
    }
}
