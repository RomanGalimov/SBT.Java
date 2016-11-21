package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by NecroS on 11/15/2016.
 */
public class IceCreamSurprise extends IceCream {


    @Override
    public String toString() {
        StringBuilder report = new StringBuilder("");
        String toppingString = "";
        report.append(String.format("Контейнер: %s вкус %s. \n", getIceCreamContainer(), getIceCreamTaste()));
        for (product p : IceCreamTopping
                ) {
            toppingString += String.format("Добавка: %s цена: %d\n", p.getName(), p.getPrice());
        }
        report.append(toppingString);
        report.append(String.format("Стоимость: %d", getPrice()));

        return report.toString();
    }

    IceCreamSurprise(ContainerAssortment cont, Assortment cream, Assortment toppingassort) {
        Random rnd = new Random();
        List<product> currentToping = new ArrayList<>();
        System.out.println("Создаем мороженое сюрприз!");
        setIceCreamContainer(cont.getContainer(rnd.nextInt(cont.getContainerAssortmentSize() - 1)));
        setIceCreamTaste(cream.getAssortment(rnd.nextInt(cream.getAssortmentSize() - 1)));
        CalculateBaseprice();
        currentToping.add(toppingassort.getAssortment(rnd.nextInt(toppingassort.getAssortmentSize() - 1)));
        currentToping.add(toppingassort.getAssortment(rnd.nextInt(toppingassort.getAssortmentSize() - 1)));
        setIceCreamTopping(currentToping);
        CalculatePrice();
    }
}
