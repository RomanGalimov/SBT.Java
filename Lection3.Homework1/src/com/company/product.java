package com.company;

/**
 * Created by NecroS on 11/15/2016.
 */
public class product {
    private String Name;
    private int Price;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public product(String name, int price) {
        setName(name);
        setPrice(price);
    }
}
