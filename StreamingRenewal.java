import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    String getName() {
        return name;
    }

    abstract int validityDays();

    LocalDate renewalDate() {
        return startDate.plusDays(validityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 30;
    }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 90;
    }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int validityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    static Plan create(String type, String name, LocalDate date) {
        switch (type.toUpperCase()) {
            case "BASIC":
                return new BasicPlan(name, date);
            case "STANDARD":
                return new StandardPlan(name, date);
            default:
                return new PremiumPlan(name, date);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            plans.add(create(type, name, date));
        }
        for (Plan p : plans) {
            System.out.println(p.getName() + ": " + p.renewalDate());
        }
        sc.close();
    }
}
