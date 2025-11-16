import java.util.ArrayList;

public class Inventory {

    public ArrayList<Item> items = new ArrayList<>();
    public String boxName;

    public Inventory(String name) {
        this.boxName = name;
    }

    public void add(Item item) {
        items.add(item);
        System.out.println("Add " + item.name + " in " + boxName);
    }

    public void remove(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).name.equals(itemName)) {
                items.remove(i);
                System.out.println("Remove " + itemName + " from " + boxName);
                return;
            }
        }

        System.out.println(": (");

    }

    public void show() {

         System.out.println("--- " + boxName + " ---");
         for (Item item : items) {
             System.out.println("-" + item.name);
         }

         if (items.isEmpty()) {
             System.out.println("Empty");
         }

    }

    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.name.equals(itemName)) {
                return true;
            }
        }
        return false;
    }

}
