package threads;

public class Car implements Runnable {
    private final String name;
    private final ParkingLot parkingLot;

    public Car(String name, ParkingLot parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
    }

    @Override
    public void run() {
        try {
            String parkingSpace = parkingLot.park(name);
            if (parkingSpace != null) {
                Thread.sleep((long) (Math.random() * 10000));
                parkingLot.leave(name, parkingSpace);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}