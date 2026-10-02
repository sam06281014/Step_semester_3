import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double fee();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    double fee() {
        return amount * 0.02;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    double fee() {
        return 0;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    double fee() {
        return amount * 0.01;
    }
}

class PaymentProcessor {
    double totalFees(List<Payment> payments) {
        double total = 0;
        for (Payment p : payments) {
            total += p.fee();
        }
        return total;
    }
}

public class ExtensionDemo {
    public static void main(String[] args) {
        List<Payment> list = new ArrayList<>();
        list.add(new CardPayment(1000));
        list.add(new BankTransferPayment(2000));
        list.add(new WalletPayment(500));
        System.out.println(new PaymentProcessor().totalFees(list));
    }
}
