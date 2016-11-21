package com.company;

/**
 * Created by NecroS on 11/15/2016.
 */
public class Container {
    private String Name;
    private int PriceMultiplier;
    private int Price;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPriceMultiplier() {
        return PriceMultiplier;
    }

    public void setPriceMultiplier(int priceMultiplier) {
        PriceMultiplier = priceMultiplier;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Container(String name, int price, int multiplier) {
        setName(name);
        setPrice(price);
        setPriceMultiplier(multiplier);
    }
}
