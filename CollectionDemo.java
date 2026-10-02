import java.util.*;

abstract class Payment {
    abstract double fee();
}

class CardPayment extends Payment {
    double fee() {
        return 20;
    }
}

class WalletPayment extends Payment {
    double fee() {
        return 10;
    }
}

class BankPayment extends Payment {
    double fee() {
        return 0;
    }
}

public class CollectionDemo {
    public static void main(String[] args) {
        List<Payment> list = new ArrayList<>();
        list.add(new CardPayment());
        list.add(new WalletPayment());
        list.add(new BankPayment());
        double total = 0;
        for (Payment p : list) {
            total += p.fee();
        }
        System.out.println(total);
    }
}
