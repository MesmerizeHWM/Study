package com.company;

import java.util.Arrays;

public class StringList {

    private static String[] array;
    private static int capacity = 10;
    private static int iterator = 0;

    public StringList() {
        clean();
    }

    public static void add(String value){
        if (iterator < capacity) {
            array[iterator++] = value;
        } else {
            array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
            array[iterator++] = value;
        }
    }

    public static int size() {
        return iterator;
    }

    public static String get(int index) {
        return array[index];
    }

    public static void clean() {
        array = new String[capacity];
        iterator = 0;
    }
}
