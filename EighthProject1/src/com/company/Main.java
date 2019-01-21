package com.company;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String date = "15.08.1995 18:30:15";
        try(FileWriter writer = new FileWriter("TestingFile.txt", false)) {
            writer.write(getDate(date));
            writer.append(" ");
            writer.append(getTime(date));
        } catch(Exception e) {
            System.out.println("Error");
        }
    }

    public static String getDate(String dateEntered) throws Exception {
        Date dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(dateEntered);
        return dateFormat.toString().substring(8,10) + " " + dateFormat.toString().substring(4,7);
    }

    public static String getTime(String dateEntered) throws Exception {
        Date dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(dateEntered);
        return dateFormat.toString().substring(11,16);
    }
}
