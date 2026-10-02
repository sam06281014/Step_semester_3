abstract class Employee {
    protected String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double monthly;

    FullTimeEmployee(String name, double monthly) {
        super(name);
        this.monthly = monthly;
    }

    double calculateSalary() {
        return monthly;
    }
}

class ContractEmployee extends Employee {
    private double hourlyRate;
    private int hours;

    ContractEmployee(String name, double hourlyRate, int hours) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    double calculateSalary() {
        return hourlyRate * hours;
    }
}

public class OverridingDemo {
    public static void main(String[] args) {
        Employee a = new FullTimeEmployee("Asha", 50000);
        Employee b = new ContractEmployee("Ravi", 500, 80);
        System.out.println(a.calculateSalary());
        System.out.println(b.calculateSalary());
    }
}
