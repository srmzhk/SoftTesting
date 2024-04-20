package collections;

public class Equipment implements Comparable<Equipment> {
    public enum Type {helmet, turtle, overalls, boots, kneePads, elbowPads, gloves, pants, jacket};

    private Type type;
    private String name = "";
    private int weight = 0;
    private int price = 0;

    public Equipment(Type type, String name, int weight, int price) {
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }


    @Override
    public int compareTo(Equipment eq) {
        return eq.getWeight() - this.getWeight();
    }
}
