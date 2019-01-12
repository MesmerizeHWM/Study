package Variables;

public class Main {

    public static void main(String[] args) {
        //variable definition
        byte a = 126;
        short b = 10000;
        int c = 210000;
        long d = 215004555;
        float e = (float) 12.0;
        double f = 12.4;
        boolean g = true;
        char h = 'b';
        String name = "Stanislav";

        //basic math operations
        double sum = c + e;
        int subtraction = c - (int) f;
        long multiplication = (short) e * (int) f;
        int devision = c / b;
        int remain = b % a;

        //variables printout
        System.out.println("Byte a: " + a);
        System.out.println("Short b: " + b);
        System.out.println("Integer c: " + c);
        System.out.println("Long d: " + d);
        System.out.println("Float e: " + e);
        System.out.println("Double f: " + f);
        System.out.println("Boolean g: " + g);
        System.out.println("Char h: " + h);
        System.out.println("String name: " + name);
        System.out.println(e + " + " + c + "= " + sum);
        System.out.println(c + " - " + f + "= " + subtraction);
        System.out.println(e + " * " + f + "= " + multiplication);
        System.out.println(c + " / " + b + "= " + devision);
        System.out.println(b + " % " + a + "= " + remain);
    }
}
