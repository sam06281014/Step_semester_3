// Problem 2: Weekly Staff Pay
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;

    FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;

    HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours > 40) {
            return 40 * rate + (hours - 40) * 1.5 * rate;
        }
        return hours * rate;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class P2_WeeklyStaffPay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Staff> staffList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            Staff staff;
            if (type.equalsIgnoreCase("FULLTIME")) {
                staff = new FullTimeStaff(name, Double.parseDouble(tokens[2]));
            } else if (type.equalsIgnoreCase("HOURLY")) {
                staff = new HourlyStaff(name, Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
            } else {
                staff = new Intern(name, Double.parseDouble(tokens[2]));
            }
            staffList.add(staff);
        }

        double totalPayroll = 0;
        for (Staff staff : staffList) {
            double pay = staff.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f%n", staff.name, pay);
        }

        System.out.printf("Total Payroll: %.2f%n", totalPayroll);
        sc.close();
    }
}
