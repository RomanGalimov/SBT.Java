package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final float  ROUNDPI = 3.14F;
        Scanner in = new Scanner(System.in);
        System.out.print("Введите радиус круга ");
        int number = in.nextInt();
        System.out.println("Площадь круга: " + ROUNDPI*(number*number));

        byte a=13;
        double b;
        b=a;
        System.out.println(b);
    }
}
