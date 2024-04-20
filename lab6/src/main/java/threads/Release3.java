package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Release3 {
    public static void main(String[] args) {
        int parkingCapacity = 5;
        ParkingLot parkingLot = new ParkingLot(parkingCapacity);
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 10; i++) {
            executor.execute(new Car("Car " + i, parkingLot));
        }

        executor.shutdown();
    }
}
