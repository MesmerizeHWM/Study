package com.company;

public class Main {

    public static int[] brick = new int[]{2,4,5};
    public static int[] hole = new int[]{1,3};
    public static int brickMinSide, brickMidSide, brickMaxSide, holeMinSide, holeMaxSide;

    public static void main(String[] args) {
        calculateBrickSides(brick);
        calculateHoleSides(hole);
        if (brickMinSide <= holeMinSide && brickMidSide <= holeMaxSide) {
            System.out.println("Кирпич проходит через дыру");
        } else {
            System.out.println("Кирпич не проходит :(");
        }
    }

    public static void calculateBrickSides(int[] brick) {
        brickMidSide = brick[0];
        brickMaxSide = brick[0];
        brickMinSide = brick[0];
        if (!(brick[0] == brick[1] && brick[1] == brick[2])) {
            for (int i = 0; i < brick.length; i++) {
                if (brick[i] < brickMinSide) {
                    brickMinSide = brick[i];
                } else if (brick[i] > brickMaxSide) {
                    brickMaxSide = brick[i];
                } else {
                    brickMidSide = brick[i];
                }
            }
        }
    }

    public static void calculateHoleSides(int[] hole) {
        holeMinSide = brick[0];
        holeMaxSide = brick[0];
        for (int i = 0; i < hole.length; i++) {
            if (hole[i] < holeMinSide) {
                holeMinSide = hole[i];
            } else {
                holeMaxSide = hole[i];
            }
        }
    }
}
