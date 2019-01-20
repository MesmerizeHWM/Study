package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	    StringList numberOfLines = new StringList();
	    StringList numberOfStrings = new StringList();

        FileReader fr = new FileReader("C:\\Users\\Stas\\IdeaProjects\\EighthProject2\\Test.txt");
        Scanner scannerLine = new Scanner(fr);

        while (scannerLine.hasNextLine()) {
            numberOfLines.add(scannerLine.nextLine());
        }
        System.out.println("Number of lines" + numberOfLines.size());
        scannerLine.close();

        Scanner scannerString = new Scanner(fr);
        scannerString.useDelimiter(" ");
        while (scannerString.hasNext()) {
            numberOfStrings.add(scannerString.next());
        }
        System.out.println("Number of strings" + numberOfStrings.size());
        scannerString.close();

    }
}
