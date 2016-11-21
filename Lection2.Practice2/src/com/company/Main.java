package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer a = new Integer(6);
        Float b = new Float(6.4f);
        Double c = new Double(7.8d);
        String s1 = a.toString();
        String s2 = b.toString();
        String s3 = c.toString();

        Integer s11 = new Integer(s1);
        Float s22 = new Float(s2);
        Double s33 = new Double(s3);
        System.out.println(s11 +" "+ s22 +" "+ s33);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Введите строку для анализ на полином(exit для выхода)");
            if(sc.hasNext("exit")){
                break;
            }

            String inputstr = sc.nextLine();
            System.out.println("Polydrom? " + polydrom(inputstr));

        }while(true);


    }

    public static boolean polydrom(String stdin){
        System.out.println(stdin);
        stdin=stdin.toLowerCase().trim().replace(" ","");
        if(stdin.isEmpty()){
            return false;
        }
        char[] charray = new char[stdin.length()];

        for(int i=stdin.length()-1, j=0; i>=0; i--,j++){
            charray[j]=stdin.charAt(i);
        }
        String sb = new String(charray);
        System.out.println(sb);

        return stdin.equals(sb);
    }
}
