import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }

    abstract int loanDays();

    LocalDate dueDate(LocalDate today) {
        return today.plusDays(loanDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int loanDays() {
        return 14;
    }
}

class Dvd extends LibraryItem {
    Dvd(String title) {
        super(title);
    }

    int loanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int loanDays() {
        return 3;
    }
}

public class LibraryDueDates {
    static List<String> tokens(String line) {
        List<String> r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean quoted = false;
        for (char c : line.toCharArray()) {
            if (c == '"') {
                quoted = !quoted;
            } else if (c == ' ' && !quoted) {
                if (sb.length() > 0) {
                    r.add(sb.toString());
                    sb.setLength(0);
                }
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            r.add(sb.toString());
        }
        return r;
    }

    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new Book(title);
            case "DVD":
                return new Dvd(title);
            default:
                return new Magazine(title);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate today = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> t = tokens(sc.nextLine().trim());
            items.add(create(t.get(0), t.get(1)));
        }
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(today));
        }
        sc.close();
    }
}
