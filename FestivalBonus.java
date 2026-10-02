import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    abstract double bonus();
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double bonus() {
        return 2000.0;
    }
}

public class FestivalBonus {
    static Employee create(String type, String name, double salary) {
        switch (type.toUpperCase()) {
            case "FULLTIME":
                return new FullTimeEmployee(name, salary);
            case "PARTTIME":
                return new PartTimeEmployee(name, salary);
            default:
                return new Intern(name, salary);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();
            employees.add(create(type, name, salary));
        }
        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            total += b;
            System.out.println(e.getName() + ": " + String.format(Locale.US, "%.2f", b));
        }
        System.out.println("Total Bonus: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}
