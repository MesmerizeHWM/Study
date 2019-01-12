package com.company;

import java.util.Scanner;

public class Main {

    public static final int SECONDS_IN_MINUTE = 60;

    public static void main(String[] args) {
        int countOfRepetions = getСountOfRepetions();
        int numberOfPullUps = calculateNumberOfPullUps(countOfRepetions);
        int time = calculateTime(countOfRepetions);
        System.out.println("Number of pull-ups: " + numberOfPullUps);
        System.out.println("Time: " + String.format("%02d", time / SECONDS_IN_MINUTE) + ":" + String.format("%02d", time % SECONDS_IN_MINUTE));
    }

    public static int getСountOfRepetions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of repetitions: ");
        int countOfRepitions = scanner.nextInt();
        return countOfRepitions;
    }

    public static int calculateTime(int count) {
        int time = 0;
        int timeBreak = 60;
        for (int i = 1; i < count; i++) {
            time += timeBreak;
            timeBreak += timeBreak / 5;
        }
        time += 5 * calculateNumberOfPullUps(count);
        return time;
    }

    public static int calculateNumberOfPullUps(int count) {
        int numberOfPullUps = (1 + count) * count / 2;
        return numberOfPullUps;
    }
}
