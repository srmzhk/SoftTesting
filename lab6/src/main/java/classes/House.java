package classes;

public class House {
    private int id = 0;
    private int flatNumber = 0;
    private double square = 0;
    private int floor = 0;
    private int roomsAmount = 0;
    private String street = "";
    private String buildingType = "";
    private int serviceLife = 0;

    public House(int id, int flatNumber, double square, int floor, int roomsAmount, String street,
                 String buildingType, int serviceLife) {
        this.id = id;
        this.flatNumber = flatNumber;
        this.square = square;
        this.floor = floor;
        this.roomsAmount = roomsAmount;
        this.street = street;
        this.buildingType = buildingType;
        this.serviceLife = serviceLife;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(int roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(int serviceLife) {
        this.serviceLife = serviceLife;
    }

    public void print(){
        System.out.println("House:\n"
                            + "id: " + id + "\n"
                            + "flat number: " + flatNumber + "\n"
                            + "square: " + square + "\n"
                            + "floor: " + floor + "\n"
                            + "rooms amount: " + roomsAmount + "\n"
                            + "street: " + street + "\n"
                            + "building type: " + buildingType + "\n"
                            + "service life: " + serviceLife + "\n");
    }
}
