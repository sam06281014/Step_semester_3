class Account {
    protected String id;
    protected double balance;

    Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    String getId() {
        return id;
    }

    double interest() {
        return balance * 0.03;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String id, double balance) {
        super(id, balance);
    }

    double interest() {
        return balance * 0.05;
    }
}

public class InheritedOverriddenDemo {
    public static void main(String[] args) {
        Account a = new Account("A1", 1000);
        Account s = new SavingsAccount("S1", 1000);
        System.out.println(a.getId() + " " + a.interest());
        System.out.println(s.getId() + " " + s.interest());
    }
}
