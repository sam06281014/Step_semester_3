import java.util.*;

abstract class Delivery {
    protected double weight;
    protected double distance;

    Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    abstract String getType();

    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "STANDARD";
    }

    double fee() {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double weight, double distance) {
        super(weight, distance);
    }

    String getType() {
        return "EXPRESS";
    }

    double fee() {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    InternationalDelivery(double weight, double distance,
                          double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    String getType() {
        return "INTERNATIONAL";
    }

    double fee() {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            if (type.equals("INTERNATIONAL")) {
                double customs = sc.nextDouble();
                list.add(new InternationalDelivery(weight, distance, customs));
            } else if (type.equals("EXPRESS")) {
                list.add(new ExpressDelivery(weight, distance));
            } else {
                list.add(new StandardDelivery(weight, distance));
            }
        }
        double total = 0;
        for (Delivery d : list) {
            double f = d.fee();
            total += f;
            String out = String.format(Locale.US, "%.2f", f);
            System.out.println(d.getType() + ": " + out);
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}
