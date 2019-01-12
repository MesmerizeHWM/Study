package com.company;

public class Main {

    public static final double number = 8;

    public static void main(String[] args) {
	    double tmp = number / 2;
	    double botBorder = 0;
	    double topBorder = number;
	    while (true) {
            if ((tmp * tmp < number + 0.0001) && (tmp * tmp > number - 0.0001)) {
                System.out.println("Корень числа 8 равен " + tmp);
                break;
            } else if (tmp * tmp < number) {
	            botBorder = tmp;
            } else {
                topBorder = tmp;
            }
            tmp = (topBorder + botBorder) / 2;
        }
    }
}
