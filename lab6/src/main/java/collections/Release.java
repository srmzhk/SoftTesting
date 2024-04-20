package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Release {
    public static void main(String[] args) {
        List<Equipment> list = new ArrayList<>();
        list.add(new Equipment(Equipment.Type.helmet, "AGV K1 S", 1500, 500));
        list.add(new Equipment(Equipment.Type.turtle, "ALPINESTARS BIONIC TECH V2", 2100, 310));
        list.add(new Equipment(Equipment.Type.overalls, "ALPINESTARS MISSILE V2", 5200, 1230));
        list.add(new Equipment(Equipment.Type.boots, "SECA COMET CLIMA HDRY", 800, 170));
        list.add(new Equipment(Equipment.Type.kneePads, "FORMA TRI-FLEX", 300, 87));
        list.add(new Equipment(Equipment.Type.elbowPads, "ALPINESTARS MX SEQUENCE", 350, 85));
        list.add(new Equipment(Equipment.Type.gloves, "SECA UKEMI PRO", 420, 120));
        list.add(new Equipment(Equipment.Type.pants, "ALPINESTARS MISSILE", 760, 465));
        list.add(new Equipment(Equipment.Type.jacket, "КОЖАНАЯ ALPINESTARS GP FORCE", 1005, 690));

        list.forEach(System.out::println);
        Collections.sort(list);
        System.out.println("\nSorted list:");
        list.forEach(System.out::println);
        int priceStart = 100;
        int priceEnd = 1100;
        System.out.println("\nFilter list by price[" + priceStart + ", " + priceEnd + "]");
        list.stream().filter(eq -> eq.getPrice() > priceStart && eq.getPrice() < priceEnd).sorted().forEach(System.out::println);
    }
}
