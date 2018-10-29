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

    ShoppingCart add(Product product, int quantity) {
        if (!items.containsKey(product)) {
            items.put(product, new Item(product, quantity));
        } else {
            Item existingItem = items.get(product);
            items.put(product, existingItem.plus(quantity));
        }
        return this;
    }

    public double total() {
<<<<<<< HEAD
        double totalprice = 0;
       for(Item item: items()){
           totalprice += item.product.getprice();
       }
           return totalprice;
=======
        double totalPrice = 0;
        int totalQuantity = 0;
        for (Item item : items()) {
            totalQuantity += item.quantity;

            if (item.quantity >= 3) {
                totalPrice += item.product.getprice() * (item.quantity - 1);
            } else {
                totalPrice += item.product.getprice() * item.quantity;
            }


        }


        return totalPrice;

>>>>>>> 13ed8cbdc4fa40f252a117425b320e11a685e2fc
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

        private Item plus(int quantity) {
            return new Item(product, this.quantity + quantity);
        }
    }
}
