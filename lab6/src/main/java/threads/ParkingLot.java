package threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private final int capacity;
    private final LinkedBlockingQueue<String> parkingSpaces;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingSpaces = new LinkedBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            parkingSpaces.offer("ParkingSpace " + (i + 1));
        }
    }

    public String park(String car) throws InterruptedException {
        String parkingSpace = parkingSpaces.poll(5, TimeUnit.SECONDS); // Wait for 5 seconds
        if (parkingSpace != null) {
            System.out.println(car + " parked at " + parkingSpace);
            return parkingSpace;
        } else {
            System.out.println(car + " couldn't find a parking space and left.");
            return null;
        }
    }

    public void leave(String car, String parkingSpace) {
        parkingSpaces.offer(parkingSpace);
        System.out.println(car + " left " + parkingSpace);
    }
}
