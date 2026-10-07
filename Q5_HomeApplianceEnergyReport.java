// Problem 5: Home Appliance Energy Report
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverModeCapable {
    double SAVER_REDUCTION = 0.25; // written once, shared by every saver-capable appliance

    default double applySaverMode(double units) {
        return units * (1 - SAVER_REDUCTION);
    }
}

abstract class Appliance {
    static final double COST_PER_UNIT = 8.0;
    double powerWatts;

    Appliance(double powerWatts) {
        this.powerWatts = powerWatts;
    }

    abstract String getName();

    double calculateUnits(double hours) {
        return powerWatts * hours / 1000.0;
    }
}

class FridgeAppliance extends Appliance {
    FridgeAppliance() {
        super(150.0);
    }

    String getName() {
        return "FRIDGE";
    }
}

class AcAppliance extends Appliance implements SaverModeCapable {
    AcAppliance() {
        super(1500.0);
    }

    String getName() {
        return "AC";
    }
}

class TvAppliance extends Appliance {
    TvAppliance() {
        super(100.0);
    }

    String getName() {
        return "TV";
    }
}

class WasherAppliance extends Appliance implements SaverModeCapable {
    WasherAppliance() {
        super(500.0);
    }

    String getName() {
        return "WASHER";
    }
}

public class Q5_HomeApplianceEnergyReport {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saverRequested = tokens.length > 2 && tokens[2].equalsIgnoreCase("SAVER");

            Appliance appliance;
            if (type.equalsIgnoreCase("FRIDGE")) {
                appliance = new FridgeAppliance();
            } else if (type.equalsIgnoreCase("AC")) {
                appliance = new AcAppliance();
            } else if (type.equalsIgnoreCase("TV")) {
                appliance = new TvAppliance();
            } else {
                appliance = new WasherAppliance();
            }

            double units = appliance.calculateUnits(hours);

            if (saverRequested) {
                if (appliance instanceof SaverModeCapable) {
                    units = ((SaverModeCapable) appliance).applySaverMode(units);
                } else {
                    System.out.println(appliance.getName() + ": saver mode not supported");
                    continue;
                }
            }

            double cost = units * Appliance.COST_PER_UNIT;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", appliance.getName(), units, cost);
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
