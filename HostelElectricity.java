import java.util.*;

abstract class Room {
    protected long units;

    Room(long units) {
        this.units = units;
    }

    abstract String getType();

    abstract double bill();
}

class SingleRoom extends Room {
    SingleRoom(long units) {
        super(units);
    }

    String getType() {
        return "SINGLE";
    }

    double bill() {
        return 8.0 * units;
    }
}

class SharedRoom extends Room {
    private int occupants;

    SharedRoom(long units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    String getType() {
        return "SHARED";
    }

    double bill() {
        return (6.0 * units) / occupants;
    }
}

class ACRoom extends Room {
    ACRoom(long units) {
        super(units);
    }

    String getType() {
        return "AC";
    }

    double bill() {
        return 10.0 * units + 200.0;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            long units = sc.nextLong();
            if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            } else {
                rooms.add(new SingleRoom(units));
            }
        }
        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(r.getType() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}
