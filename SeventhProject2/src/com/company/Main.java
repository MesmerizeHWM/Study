package com.company;

import java.util.Scanner;

public class Main {

    private static final int SECONDS_IN_MINUTE = 60;
    private static final int MINUTES_IN_HOUR = 60;
    private static final int HOURS_IN_DAYS = 24;

    public static void main(String[] args) {
        String timePrint = "";
        int time = inputTimeInSeconds();
        if (time == 0) {
            timePrint = time + " seconds";
        } else {
            if (time / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS) > 0) {
                timePrint += Integer.toString(time / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS));
                if (time / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS) == 1) {
                    timePrint += " day ";
                } else {
                    timePrint += " days ";
                }
            }
            if (time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS) / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR) > 0) {
                timePrint += time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS) /(SECONDS_IN_MINUTE * MINUTES_IN_HOUR);
                if (time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS) / (SECONDS_IN_MINUTE * MINUTES_IN_HOUR) == 1) {
                    timePrint += " hour ";
                } else {
                    timePrint += " hours ";
                }
            }
            if (time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR) / SECONDS_IN_MINUTE > 0) {
                timePrint += time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR) / SECONDS_IN_MINUTE;
                if (time % (SECONDS_IN_MINUTE * MINUTES_IN_HOUR) / SECONDS_IN_MINUTE == 1) {
                    timePrint += " minute ";
                } else {
                    timePrint += " minutes ";
                }
            }
            if (time % SECONDS_IN_MINUTE * MINUTES_IN_HOUR * HOURS_IN_DAYS > 0) {
                timePrint += time % SECONDS_IN_MINUTE;
                if (time % SECONDS_IN_MINUTE == 1) {
                    timePrint += " second ";
                } else {
                    timePrint += " seconds ";
                }
            }
        }
        System.out.println(timePrint);
    }

    private static int inputTimeInSeconds() {
        int time = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите время в секундах: ");
            time  = scanner.nextInt();
            if (time < 0) {
                System.out.println("Отрицательное значение");
            }
        } catch (Exception e) {
            System.out.println("Unknown");
        }
        return time;
    }
}
