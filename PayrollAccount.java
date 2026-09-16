class PayrollAccount {
    private double basicSalary;
    private double bonus;

    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            this.basicSalary = 0;
            System.out.println("Warning: Negative salary not allowed. Set to 0.");
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0;
    }

    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount.");
        } else {
            bonus += amount;
        }
    }

    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percentage.");
        } else {
            double tax = basicSalary * percent / 100;
            basicSalary -= tax;
        }
    }

    double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount acc = new PayrollAccount(50000);
        acc.creditBonus(2000);
        acc.deductTax(10);
        System.out.println("Net Salary: " + acc.getNetSalary());

        PayrollAccount acc2 = new PayrollAccount(-5000);
        System.out.println("Net Salary: " + acc2.getNetSalary());
    }
}
