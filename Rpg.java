import java.util.Scanner;

public class Rpg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Исправлено: правильное название класса
        ItemRegistry registry = new ItemRegistry();

        int x = 0;
        int y = 0;

        Inventory bag = new Inventory("Bag");
        Inventory chest = new Inventory("Chest");

        // Добавляем предметы по ID (из реестра)
        bag.addItem(1, registry);  // Деревянный меч
        bag.addItem(2, registry); // Зелье здоровья
        bag.addItem(3, registry); // Яблоко

        while(true) {
            System.out.println("Your coordinates: x: " +  x + " y: " +  y);
            System.out.println("Enter command: ");
            String input_com = input.nextLine().toLowerCase();

            switch (input_com) {
                case "w": y++; break;
                case "a": x--; break;
                case "s": y--; break;
                case "d": x++; break;
                case "bag": bag.show(registry); break;
                case "chest": chest.show(registry); break;
                case "put":
                    System.out.println("Enter item ID to put from bag to chest:");
                    try {
                        int itemId = Integer.parseInt(input.nextLine());
                        if (bag.hasItem(itemId)) {
                            bag.removeItem(itemId, registry);
                            chest.addItem(itemId, registry);
                        } else {
                            System.out.println(": (");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(": (");
                    }
                    break;
                case "take":
                    System.out.println("Enter item ID to take from chest to bag:");
                    try {
                        int itemId = Integer.parseInt(input.nextLine());
                        if (chest.hasItem(itemId)) {
                            chest.removeItem(itemId, registry);
                            bag.addItem(itemId, registry);
                        } else {
                            System.out.println(": (");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(": (");
                    }
                    break;
                case "exit":
                    System.out.println("Good luck!");
                    return;
                default:
                    System.out.println(": (");
            }
        }
    }
}
