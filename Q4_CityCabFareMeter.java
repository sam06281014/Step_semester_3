// Problem 4: City Cab Fare Meter
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightServiceCapable {
    double NIGHT_SURCHARGE_RATE = 0.20; // written once, shared by every night-capable cab type

    default double applyNightSurcharge(double fare) {
        return fare * (1 + NIGHT_SURCHARGE_RATE);
    }
}

abstract class Cab {
    static final double MINIMUM_FARE = 100.0; // shared minimum-fare rule
    double ratePerKm;

    Cab(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    abstract String getType();

    double calculateBaseFare(double km) {
        double fare = km * ratePerKm;
        return Math.max(fare, MINIMUM_FARE);
    }
}

class MiniCab extends Cab {
    MiniCab() {
        super(10.0);
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightServiceCapable {
    SedanCab() {
        super(14.0);
    }

    String getType() {
        return "SEDAN";
    }
}

class SuvCab extends Cab implements NightServiceCapable {
    SuvCab() {
        super(18.0);
    }

    String getType() {
        return "SUV";
    }
}

public class Q4_CityCabFareMeter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double km = Double.parseDouble(tokens[1]);
            String time = tokens[2];

            Cab cab;
            if (type.equalsIgnoreCase("MINI")) {
                cab = new MiniCab();
            } else if (type.equalsIgnoreCase("SEDAN")) {
                cab = new SedanCab();
            } else {
                cab = new SuvCab();
            }

            double baseFare = cab.calculateBaseFare(km);

            if (time.equalsIgnoreCase("NIGHT")) {
                if (cab instanceof NightServiceCapable) {
                    double fare = ((NightServiceCapable) cab).applyNightSurcharge(baseFare);
                    total += fare;
                    System.out.printf("%s: %.2f%n", cab.getType(), fare);
                } else {
                    System.out.println(cab.getType() + ": night service not available");
                }
            } else {
                total += baseFare;
                System.out.printf("%s: %.2f%n", cab.getType(), baseFare);
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
