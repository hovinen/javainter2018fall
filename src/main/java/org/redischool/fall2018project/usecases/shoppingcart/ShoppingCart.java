package org.redischool.fall2018project.usecases.shoppingcart;

import com.google.common.collect.ImmutableList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

public class ShoppingCart {
    private final Map<Product, Item> items = new LinkedHashMap<>();

    public List<Item> items() {
        return ImmutableList.copyOf(items.values());
    }

    public void addItem(Item item) {
        items.put(item.product, item);
    }

    void add(Product product, int quantity) {
        if (!items.containsKey(product)) {
            addItem(new Item(product, quantity));
        } else {
            items.put(product, new Item(product, items.get(product).quantity + quantity));
        }
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
