package org.redischool.fall2018project.usecases.shoppingcart;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class ShoppingCart {
    private final List<Item> items = new ArrayList<>();

    public List<Item> items() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addToItem(int quantity) {
        Item item = items.get(0);
        items.set(0, new Item(item.product, item.quantity + quantity));
    }

    static class Item {
        private final Product product;
        private final int quantity;

        public Item(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Item) {
                Item other = (Item) obj;
                return Objects.equals(product, other.product) && quantity == other.quantity;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return toStringHelper(this).add("product", product).add("quantity", quantity).toString();
        }
    }
}
