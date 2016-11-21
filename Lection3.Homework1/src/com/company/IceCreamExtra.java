package com.company;

import java.util.List;

/**
 * Created by NecroS on 11/15/2016.
 */
public class IceCreamExtra extends IceCream {
    protected product drink;
    
    public void addDrink(product productName){
        this.drink = productName;
        CalculatePrice();
    }

    @Override
    public void addIceCreamTopping(product iceCreamTopping) {
        System.out.println("Для данного мороженого нельзя добавить топинги");
    }

    @Override
    public void setIceCreamTopping(List<product> IceCreamTopping) {
        System.out.println("Для данного мороженого нельзя добавить топинги");
    }

    @Override
    protected void CalculatePrice() {
        this.price = drink.getPrice() + this.baseprice;
    }

    @Override
    protected void CalculateBaseprice() {
        super.CalculateBaseprice();
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder("");
        report.append(String.format("Контейнер: %s вкус %s.\n", getIceCreamContainer(), getIceCreamTaste()));
        report.append(String.format("Напиток: %S\n", drink.getName()));
        report.append(String.format("Стоимость: %d", getPrice()));

        return report.toString();
    }

    public IceCreamExtra(Container container, product cream){
        super(container,cream);
    }
}
