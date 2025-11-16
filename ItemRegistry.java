import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    private Map<Integer, Item> allItems = new HashMap<>();

    public ItemRegistry() {
        initializeAllItems();
    }

    private void initializeAllItems() {
        registerItem(1, new Item("Wooden sword", "weapon"));
        registerItem(2, new Item("Mana Potion", "potion"));
        registerItem(3, new Item("Bread", "food"));
    }

    private void registerItem(int id, Item item) {
        allItems.put(id, item);
    }

    public Item getItemById(int id) {
        Item item = allItems.get(id);
        if (item == null) {
            System.out.println(": (");
        } return item;
    }
}
