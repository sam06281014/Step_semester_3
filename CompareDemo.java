abstract class Customer {
    abstract double discount(double amount);
}

class Student extends Customer {
    double discount(double amount) {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    double discount(double amount) {
        return amount * 0.95;
    }
}

public class CompareDemo {
    static double withConditionals(String type, double amount) {
        if (type.equals("STUDENT")) {
            return amount * 0.90;
        } else if (type.equals("STAFF")) {
            return amount * 0.95;
        }
        return amount;
    }

    public static void main(String[] args) {
        System.out.println(withConditionals("STUDENT", 200));
        Customer c = new Student();
        System.out.println(c.discount(200));
    }
}
