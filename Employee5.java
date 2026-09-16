class Employee5 {
    String empName;
    double salary;

    static String companyName = "TechNova Solutions";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Employees: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Arjun", 30000);
        Employee e2 = new Employee("Meera", 35000);
        Employee e3 = new Employee("Kabir", 40000);

        Employee.printCompanyInfo();
    }
}
