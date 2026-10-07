// Problem 1: Movie Ticket Counter
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Ticket {
    static final double CONVENIENCE_FEE = 20.0; // written once, shared by every seat type
    int count;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPricePerTicket();

    abstract String getSeatType();

    double calculateAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends Ticket {
    RegularTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 150.0;
    }

    String getSeatType() {
        return "REGULAR";
    }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 250.0;
    }

    String getSeatType() {
        return "PREMIUM";
    }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int count) {
        super(count);
    }

    double getPricePerTicket() {
        return 400.0;
    }

    String getSeatType() {
        return "RECLINER";
    }
}

public class Q1_MovieTicketCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Ticket> tickets = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String seat = tokens[0];
            int count = Integer.parseInt(tokens[1]);

            Ticket ticket;
            if (seat.equalsIgnoreCase("REGULAR")) {
                ticket = new RegularTicket(count);
            } else if (seat.equalsIgnoreCase("PREMIUM")) {
                ticket = new PremiumTicket(count);
            } else {
                ticket = new ReclinerTicket(count);
            }
            tickets.add(ticket);
        }

        double total = 0;
        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();
            total += amount;
            System.out.printf("%s: %.2f%n", ticket.getSeatType(), amount);
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
