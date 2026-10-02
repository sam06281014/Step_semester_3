import java.util.*;

abstract class VehicleRental {
    protected String customer;
    protected int days;
    protected double dailyRate;

    VehicleRental(String customer, int days, double dailyRate) {
        this.customer = customer;
        this.days = days;
        this.dailyRate = dailyRate;
    }

    abstract double surcharge();

    double totalCost() {
        return days * dailyRate + surcharge();
    }

    String getCustomer() {
        return customer;
    }
}

class CarRental extends VehicleRental {
    CarRental(String customer, int days, double dailyRate) {
        super(customer, days, dailyRate);
    }

    double surcharge() {
        return days * 200;
    }
}

class TruckRental extends VehicleRental {
    private double loadTons;

    TruckRental(String customer, int days, double dailyRate,
                double loadTons) {
        super(customer, days, dailyRate);
        this.loadTons = loadTons;
    }

    double surcharge() {
        return loadTons * 500;
    }
}

public class VehicleRentalDemo {
    public static void main(String[] args) {
        List<VehicleRental> rentals = new ArrayList<>();
        rentals.add(new CarRental("Asha", 3, 1500));
        rentals.add(new TruckRental("Ravi", 2, 4000, 5));
        for (VehicleRental r : rentals) {
            System.out.println(r.getCustomer() + ": " + r.totalCost());
        }
    }
}
