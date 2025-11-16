import java.util.Scanner;

public class Rpg {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int x = 0;
        int y = 0;

        Inventory bag = new Inventory("Bag");
        Inventory chest = new Inventory("Chest");

        Item sword = new Item("Sword");
        Item potion = new Item("Potion");

        chest.add(sword);
        chest.add(potion);

        while(true) {

            System.out.println("Your coordinates: x: " +  x + " y: " +  y);
            System.out.println("Enter command: ");
            String input_com = input.nextLine().toLowerCase();

            switch (input_com) {

                case "w": y++; break;
                case "a": x--; break;
                case "s": y--; break;
                case "d": x++; break;
                case "bag": bag.show(); break;
                case "chest": chest.show(); break;
                case "put":
                    System.out.println("What subject do you want to put?");
                    String itemToPut = input.nextLine();
                    if (itemToPut.equalsIgnoreCase("sword") && bag.hasItem("Sword")) {
                        bag.remove("Sword");
                        chest.add(sword);
                    } else if (itemToPut.equalsIgnoreCase("potion") && bag.hasItem("Potion")) {
                        bag.remove("Potion");
                        chest.add(potion);
                    } else {
                        System.out.println(": (");
                    }
                    break;
                case "take":
                    System.out.println("What subject do you want to take?");
                    String itemToTake = input.nextLine();
                    if (itemToTake.equalsIgnoreCase("sword") && chest.hasItem("Sword")) {
                        chest.remove("Sword");
                        bag.add(sword);
                    } else if (itemToTake.equalsIgnoreCase("potion") && chest.hasItem("Potion")) {
                        chest.remove("Potion");
                        bag.add(potion);
                    } else {
                        System.out.println(": (");
                    }
                    break;
                case "exit":
                    System.out.println("Good luck!");
                    return;
                default:
                    System.out.println(" ");

            }
        }
    }
}
