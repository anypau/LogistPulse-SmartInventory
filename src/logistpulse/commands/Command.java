
package logistpulse.inventory;

import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {

    private final Map<String, Integer> products = new LinkedHashMap<>();

    public void addStock(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        int current = products.getOrDefault(product, 0);
        products.put(product, current + quantity);

        System.out.println("Added " + quantity + " units of " + product);
    }

    public void removeStock(String product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        int current = products.getOrDefault(product, 0);

        if (current < quantity) {
            throw new IllegalArgumentException("Not enough stock for " + product);
        }

        products.put(product, current - quantity);

        System.out.println("Removed " + quantity + " units of " + product);
    }

    public int getStock(String product) {
        return products.getOrDefault(product, 0);
    }

    public void showInventory() {
        System.out.println("\n--- CURRENT INVENTORY ---");

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(
                entry.getKey() + ": " + entry.getValue()
            );
        }
    }
}
