public class Item {
    public String name;
    public String type;

    public Item(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void describe() {
        System.out.println(name + " [" + type + "]");
    }
}
