// Problem 2: Parcel Shipping Desk
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double INSURANCE_RATE = 0.02; // interface fields are implicitly public static final

    double getDeclaredValue();

    default double calculateInsurance() {
        return getDeclaredValue() * INSURANCE_RATE;
    }
}

abstract class Parcel {
    double weightKg;
    double declaredValue;

    Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    abstract String getType();

    double getDeclaredValue() {
        return declaredValue;
    }
}

class StandardParcel extends Parcel {
    StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 40.0 + 10.0 * weightKg;
    }

    String getType() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        return 80.0 + 15.0 * weightKg;
    }

    String getType() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double calculateCharge() {
        double standardCharge = 40.0 + 10.0 * weightKg;
        return standardCharge + 50.0;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class Q2_ParcelShippingDesk {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double weightKg = Double.parseDouble(tokens[1]);
            double declaredValue = Double.parseDouble(tokens[2]);

            Parcel parcel;
            if (type.equalsIgnoreCase("STANDARD")) {
                parcel = new StandardParcel(weightKg, declaredValue);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcel = new ExpressParcel(weightKg, declaredValue);
            } else {
                parcel = new FragileParcel(weightKg, declaredValue);
            }
            parcels.add(parcel);
        }

        double grandTotal = 0;
        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).calculateInsurance() : 0.0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    parcel.getType(), charge, insurance, total);
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
