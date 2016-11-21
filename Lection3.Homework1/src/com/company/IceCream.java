package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NecroS on 11/15/2016.
 */
public class IceCream {
    private Container iceCreamContainer;
    private product IceCreamTaste;
    protected List<product> IceCreamTopping = new ArrayList<>();
    protected int price = 0;
    protected int baseprice = 0;

    public String getIceCreamContainer() {
        return iceCreamContainer.getName();
    }

    public void setIceCreamContainer(Container iceCreamContainer) {
        this.iceCreamContainer = iceCreamContainer;
    }

    public String getIceCreamTaste() {
        return IceCreamTaste.getName();
    }

    public void setIceCreamTaste(product iceCreamTaste) {
        IceCreamTaste = iceCreamTaste;
    }

    public void setIceCreamTopping(List<product> IceCreamTopping) {
        this.IceCreamTopping = IceCreamTopping;
    }

    public void addIceCreamTopping(product iceCreamTopping) {
        IceCreamTopping.add(iceCreamTopping);
        CalculatePrice();
    }

    public int getPrice() {
        return price;
    }

    protected void CalculatePrice() {
        price = 0;
        for (product topping : IceCreamTopping
                ) {
            price += topping.getPrice();
        }
        this.price = price + this.baseprice;
    }

    public int getBasePrice() {

        return baseprice;
    }

    protected void CalculateBaseprice() {
        this.baseprice = iceCreamContainer.getPrice() + iceCreamContainer.getPriceMultiplier() * IceCreamTaste.getPrice();
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder("");
        String toppingString = "";
        report.append(String.format("Контейнер: %s вкус %s. Цена без добавок:%d\n", getIceCreamContainer(), getIceCreamTaste(), getBasePrice()));
        if (IceCreamTopping == null || IceCreamTopping.isEmpty()) {
        } else {
            for (product p : IceCreamTopping
                    ) {
                toppingString += String.format("Добавка: %s цена: %d\n", p.getName(), p.getPrice());
            }
            report.append(toppingString);
            report.append(String.format("Цена с топпингом: %d", getPrice()));
        }

        return report.toString();
    }

    public IceCream() {
    }

    public IceCream(Container iceContainer, product baseTaste) {
        setIceCreamContainer(iceContainer);
        setIceCreamTaste(baseTaste);
        CalculateBaseprice();
    }
}
