// Problem 5: Travel Booking with a Common Fee
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    static final double BOOKING_FEE = 50.0; // single place to change the fee
    double distanceKm;

    Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    abstract double calculateFare();

    abstract String getMode();

    double getTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    BusBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2.0 * distanceKm;
    }

    String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 1.5 * distanceKm;
    }

    String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    double calculateFare() {
        return 2500.0 + 4.0 * distanceKm;
    }

    String getMode() {
        return "FLIGHT";
    }
}

public class P5_TravelBookingWithCommonFee {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String mode = tokens[0];
            double distanceKm = Double.parseDouble(tokens[1]);

            Booking booking;
            if (mode.equalsIgnoreCase("BUS")) {
                booking = new BusBooking(distanceKm);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                booking = new TrainBooking(distanceKm);
            } else {
                booking = new FlightBooking(distanceKm);
            }
            bookings.add(booking);
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n", booking.getMode(), booking.getTotal());
        }

        sc.close();
    }
}
