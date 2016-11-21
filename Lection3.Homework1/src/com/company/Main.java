package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int conNumber, creamNumber, drinkNumber;
        // write your code here
        Assortment creamAssortment = new Assortment();
        creamAssortment.addToAssortmentList("Шоколадное", 40);
        creamAssortment.addToAssortmentList("Клубничное", 30);
        creamAssortment.addToAssortmentList("Банановое", 35);
        creamAssortment.addToAssortmentList("Вишневое", 45);

        Assortment toppingAssortment = new Assortment();
        toppingAssortment.addToAssortmentList("Орехи", 10);
        toppingAssortment.addToAssortmentList("Шоколад", 5);
        toppingAssortment.addToAssortmentList("Фрукты", 15);
        toppingAssortment.addToAssortmentList("Сироп", 20);

        ContainerAssortment containerAssortment = new ContainerAssortment();
        containerAssortment.addContainer("Стаканчик", 5, 2);
        containerAssortment.addContainer("Рожок", 3, 1);

        Assortment drinkAssortment = new Assortment();
        drinkAssortment.addToAssortmentList("Cola", 12);
        drinkAssortment.addToAssortmentList("Pepsi", 13);
        drinkAssortment.addToAssortmentList("Fanta", 14);

        System.out.println("0 - Создать мороженое, 1 - мороженое сюрприз, 2 - мороженое экстра");
        switch (sc.nextInt()) {
            case 0:
                System.out.println("Выберите форму для мороженого(укажите номер):");
                System.out.println(containerAssortment.toString());
                conNumber = sc.nextInt();
                System.out.println("Выберите вкус для мороженого(укажите номер):");
                System.out.println(creamAssortment.toString());
                creamNumber = sc.nextInt();

                IceCream ic = new IceCream(containerAssortment.getContainer(conNumber), creamAssortment.getAssortment(creamNumber));

                System.out.println("Добавить топпинги? 1 - да, 0 - нет");
                if (sc.nextInt() == 1) {
                    System.out.println(toppingAssortment.toString());

                    do {
                        System.out.println("Введите номер топинга для добавления к мороженому, g для завершения зказа");
                        ic.addIceCreamTopping(toppingAssortment.getAssortment(sc.nextInt()));
                    } while (!sc.hasNext("g"));
                    sc.nextLine();
                }
                System.out.println("Ваш заказ:");
                System.out.println(ic.toString());

                break;
            case 1:
                IceCreamSurprise surp = new IceCreamSurprise(containerAssortment, creamAssortment, toppingAssortment);
                System.out.println("Ваш заказ:");
                System.out.println(surp.toString());
                break;
            case 2:
                System.out.println("Выберите форму для мороженого(укажите номер):");
                System.out.println(containerAssortment.toString());
                conNumber = sc.nextInt();
                System.out.println("Выберите вкус для мороженого(укажите номер):");
                System.out.println(creamAssortment.toString());
                creamNumber = sc.nextInt();
                IceCreamExtra extra = new IceCreamExtra(containerAssortment.getContainer(conNumber), creamAssortment.getAssortment(creamNumber));
                System.out.println("Выберите напиток(укажите номер):");
                System.out.println(drinkAssortment.toString());
                drinkNumber = sc.nextInt();
                extra.addDrink(drinkAssortment.getAssortment(drinkNumber));
                System.out.println("Ваш заказ:");
                System.out.println(extra.toString());

                break;
            default:
                System.out.println("By!");

        }


    }
}
