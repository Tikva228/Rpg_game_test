import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Integer> itemIds = new ArrayList<>();
    private String inventoryName;

    public Inventory(String name) {
        this.inventoryName = name;
    }

    public void addItem(int itemId, ItemRegistry registry) {
        if (registry.getItemById(itemId) != null) {
            itemIds.add(itemId);
            System.out.println("Add: " + registry.getItemById(itemId).name + " in " + inventoryName);
        }
    }

    public void removeItem(int itemId, ItemRegistry registry) {
        for (int i = 0; i < itemIds.size(); i++) {
            if (itemIds.get(i) == itemId) {
                itemIds.remove(i);
                System.out.println("Remove: " + registry.getItemById(itemId).name + " from " + inventoryName);
                return;
            }
        }
        System.out.println(": (");
    }

    public void show(ItemRegistry registry) {
        System.out.println("=== " + inventoryName + " ===");

        if (itemIds.isEmpty()) {
            System.out.println("Empty");
            return;
        }

        for (int id : itemIds) {
            Item item = registry.getItemById(id);
            if (item != null) {
                System.out.println("- " + item.name + " [ID: " + id + "]");
            }
        }
    }

    public boolean hasItem(int itemId) {
        return itemIds.contains(itemId);
    }
}
