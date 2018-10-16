package org.redischool.fall2018project.usecases.shoppingcart;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Product {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;


    }

    @Override
    public String toString() {
        return toStringHelper(this).add("name", name).toString();
    }

    public double getprice() {
        return price;
    }
}
