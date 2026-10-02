import java.util.*;

abstract class Payment {
    protected double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract String getType();

    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "CARD";
    }

    double finalAmount() {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    WalletPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "WALLET";
    }

    double finalAmount() {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double amount) {
        super(amount);
    }

    String getType() {
        return "BANKTRANSFER";
    }

    double finalAmount() {
        return amount;
    }
}

public class PaymentFees {
    static Payment create(String type, double amount) {
        switch (type.toUpperCase()) {
            case "CARD":
                return new CardPayment(amount);
            case "WALLET":
                return new WalletPayment(amount);
            default:
                return new BankTransferPayment(amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            list.add(create(type, amount));
        }
        double total = 0;
        for (Payment p : list) {
            double f = p.finalAmount();
            total += f;
            String out = String.format(Locale.US, "%.2f", f);
            System.out.println(p.getType() + ": " + out);
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
        sc.close();
    }
}
