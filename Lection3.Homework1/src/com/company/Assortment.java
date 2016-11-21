package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NecroS on 11/15/2016.
 */
public class Assortment {
    private List<product> products = new ArrayList<>();

    public void addToAssortmentList(String name, int price) {
        this.products.add(new product(name, price));
    }

    public product getAssortment(int number) {
        return products.get(number);
    }

    public int getAssortmentSize() {
        return products.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (product p : products
                ) {
            sb.append(String.format("%d %s %d\n", i, p.getName(), p.getPrice()));
            i++;
        }
        return sb.toString();
    }
}
