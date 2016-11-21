package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        System.out.print("Введите число ");
        int number = in.nextInt();

        if (number>0) {
            //Побитовая операция
            System.out.println(((number & (~number + 1)) == number) ? "Число является степенью двойки" : "Число не является степенью двойки");

            //Математические приемы
            while ((number != 1) && (number != 2)) {
                if (number % 2 == 0) {
                    number = number / 2;
                } else {
                    System.out.println("Число не является степенью двойки");
                    break;
                }
                if ((number == 1) || (number == 2)) System.out.println("Число является степенью двойки");
            }

        //Библиотека стандартная
        if(lg(number)%1!=0){
            System.out.println("Число не является степенью двойки");
        }else{
            System.out.println("Число является степенью двойки");
        }

        }else{
            System.out.println("Число является степенью двойки");
        }
    }

    public static double lg(double x) {
        return Math.log(x)/Math.log(2.0);

    }
}
