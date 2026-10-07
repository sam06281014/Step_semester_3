// Problem 3: Library Late Fine Counter
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 2.0 * daysLate;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(5.0 * daysLate, 50.0);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return 1.0 * daysLate;
    }
}

public class P3_LibraryLateFineCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String title = tokens[1];
            int daysLate = Integer.parseInt(tokens[2]);

            LibraryItem item;
            if (type.equalsIgnoreCase("BOOK")) {
                item = new Book(title, daysLate);
            } else if (type.equalsIgnoreCase("DVD")) {
                item = new Dvd(title, daysLate);
            } else {
                item = new Magazine(title, daysLate);
            }
            items.add(item);
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);
        sc.close();
    }
}
