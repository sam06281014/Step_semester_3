class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    String getName() {
        return name;
    }

    double pay() {
        return salary;
    }
}

class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }

    double pay() {
        return super.pay() + 5000;
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Employee e = new Manager("Asha", 50000);
        System.out.println(e.getName() + ": " + e.pay());
    }
}
