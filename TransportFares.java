import java.util.*;

abstract class Journey {
    protected double distance;

    Journey(double distance) {
        this.distance = distance;
    }

    abstract String getType();

    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "BUS";
    }

    double fare() {
        return Math.min(10.0, 2.0 + 0.10 * distance);
    }
}

class TrainJourney extends Journey {
    TrainJourney(double distance) {
        super(distance);
    }

    String getType() {
        return "TRAIN";
    }

    double fare() {
        return 3.0 + 0.15 * distance;
    }
}

class MetroJourney extends Journey {
    private double peakHourFactor;

    MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    String getType() {
        return "METRO";
    }

    double fare() {
        return (1.50 + 0.20 * distance) * peakHourFactor;
    }
}

public class TransportFares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double distance = sc.nextDouble();
            if (type.equals("METRO")) {
                double factor = sc.nextDouble();
                list.add(new MetroJourney(distance, factor));
            } else if (type.equals("TRAIN")) {
                list.add(new TrainJourney(distance));
            } else {
                list.add(new BusJourney(distance));
            }
        }
        double total = 0;
        for (Journey j : list) {
            double f = j.fare();
            total += f;
            String out = String.format(Locale.US, "%.2f", f);
            System.out.println(j.getType() + ": " + out);
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}
