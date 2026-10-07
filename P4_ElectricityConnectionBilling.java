// Problem 4: Electricity Connection Billing
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class HomeConnection extends Connection {
    HomeConnection(int units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        }
        return 100 * 5.0 + (units - 100) * 7.0;
    }

    String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    ShopConnection(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8.0 + 100.0;
    }

    String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    FactoryConnection(int units) {
        super(units);
    }

    double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }

    String getType() {
        return "FACTORY";
    }
}

public class P4_ElectricityConnectionBilling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            int units = Integer.parseInt(tokens[1]);

            Connection connection;
            if (type.equalsIgnoreCase("HOME")) {
                connection = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connection = new ShopConnection(units);
            } else {
                connection = new FactoryConnection(units);
            }
            connections.add(connection);
        }

        double total = 0;
        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
