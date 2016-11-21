package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NecroS on 11/15/2016.
 */
public class ContainerAssortment {
    private List<Container> assortmentList = new ArrayList<>();

    public void addContainer(String name, int prise, int multiplier) {
        this.assortmentList.add(new Container(name, prise, multiplier));
    }

    public Container getContainer(int number) {
        return assortmentList.get(number);
    }

    public int getContainerAssortmentSize() {
        return assortmentList.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (Container c : assortmentList
                ) {
            sb.append(String.format("%d %s %d\n", i, c.getName(), c.getPrice()));
            i++;
        }
        return sb.toString();
    }
}
