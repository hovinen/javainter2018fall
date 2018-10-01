package org.redischool.fall2018project.usecases.shoppingcart;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return toStringHelper(this).add("name", name).toString();
    }
}
