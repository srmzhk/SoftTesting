package classes;

import strings.StringsClass;
import java.util.ArrayList;
import java.util.List;

public class Release {
    public static void main(String[] args) {
        //classes
        List<House> houses = new ArrayList<House>();
        houses.add(new House(1, 1, 50.2, 1, 2, "Street1", "Hi-Tech", 50));
        houses.add(new House(2, 2, 129.7, 1, 4, "Street1", "Hi-Tech", 50));
        houses.add(new House(3, 3, 47.8, 1, 2, "Street1", "Hi-Tech", 50));
        houses.add(new House(4, 4, 98.1, 2, 3, "Street1", "Hi-Tech", 50));
        houses.add(new House(5, 5, 32.0, 2, 1, "Street2", "Hi-Tech", 50));
        houses.add(new House(6, 6, 78.5, 2, 3, "Street2", "Hi-Tech", 50));
        houses.add(new House(7, 7, 66.3, 3, 3, "Street2", "Hi-Tech", 50));
        houses.add(new House(8, 8, 150.3, 3, 5, "Street2", "Hi-Tech", 50));
        houses.add(new House(9, 9, 40.2, 4, 2, "Street3", "Hi-Tech", 50));
        houses.add(new House(10, 10, 70.1, 4, 3, "Street3", "Hi-Tech", 50));
        houses.add(new House(11, 11, 54.4, 4, 2, "Street3", "Hi-Tech", 50));
        houses.add(new House(12, 12, 32.1, 1, 1, "Street3", "Hi-Tech", 50));
//        printHousesByRoomsAmount(houses, 3);
//        printHousesByRoomsAmountAndFloor( houses,2, 1, 3);
//        printHousesWhereSquereHigherThen(houses, 50.1);

        //strings
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit tim.  Curabitur sagittis sapien metus, quis euismod dui hendrerit ornare. Nullam turpis ex, volutpat sed facilisis sit amet, malesuada eget risus. Proin purus magna, facilisis sit amet turpis eget, commodo vehicula dui. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pellentesque massa eu eleifend posuere. Phasellus luctus iaculis quam ultrices auctor. Donec id suscipit neque. Etiam vitae odio eu velit molestie volutpat. Morbi faucibus egestas arcu, ac gravida nibh aliquam ut. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nunc rutrum mollis cursus. Vivamus eu nulla volutpat, varius enim et, bibendum lorem. In suscipit ipsum ligula, a bibendum massa consectetur ac. Pellentesque vel neque in orci mollis rutrum non interdum massa. Aliquam semper consequat urna in vulputate."
                + "Proin tincidunt aliquet hendrerit. Cras ultrices venenatis augue. Etiam finibus porttitor nulla. Praesent pretium lacus eget mollis porttitor. Pellentesque scelerisque ipsum sed dictum dapibus. Suspendisse rutrum ipsum et consectetur eleifend. Donec pulvinar volutpat tellus, at malesuada lacus sagittis ac.";
//        System.out.println(StringsClass.searchUniqueWordInFirstSentence(text));
//        StringsClass.changePositionsOfFirstAndLastWords(text);
//        StringsClass.replaceWordsWithSpecifiedLength(text, 5, "hui");
//        StringsClass.printAllSentencesIncOrder(text);
        StringsClass.sortTextByAmountOfLetter(text, 'o');
    }

    public static void printHousesByRoomsAmount(List<House> houses, int roomsAmount) {
        System.out.println("Houses where roomsAmount = " + roomsAmount + "\n");
        for(House house : houses){
            if(house.getRoomsAmount() == roomsAmount)
                house.print();
        }
    }

    public static void printHousesByRoomsAmountAndFloor(List<House> houses, int roomsAmount,
                                                        int floorStart, int floorEnd) {
        System.out.println("Houses where roomsAmount = " + roomsAmount
                + " and flat interval[" + floorStart + ", " + floorEnd  + "]\n");
        for(House house : houses){
            if(house.getRoomsAmount() == roomsAmount
                    && (house.getFloor() >= floorStart && house.getFloor() <= floorEnd))
                house.print();
        }
    }

    public static void printHousesWhereSquereHigherThen(List<House> houses, double square){
        System.out.println("Houses where square > " + square + "\n");
        for(House house : houses){
            if(house.getSquare() > square)
                house.print();
        }
    }
}
