package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	    StringList linesFromFile = new StringList();

        FileReader fr = new FileReader("C:\\Users\\Stas\\IdeaProjects\\EighthProject2\\Test.txt");
        Scanner scannerLine = new Scanner(fr);

        while (scannerLine.hasNextLine()) {
            linesFromFile.add(scannerLine.nextLine());
        }
        System.out.println("Number of lines: " + linesFromFile.size());
        scannerLine.close();

        int numberOfWords = 0;
        for (int i = 0; i < linesFromFile.size(); i++) {
            for (String retval : linesFromFile.get(i).split(" ")) {
                numberOfWords++;
            }
        }
        System.out.println("Number of words: " + numberOfWords);

        int numberOfChars = 0;

        for (int i = 0; i < linesFromFile.size(); i++) {
            numberOfChars += linesFromFile.get(i).length();
        }
        System.out.println("Number of chars: " + numberOfChars);

    }
}
