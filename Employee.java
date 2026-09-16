class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + salary);
        System.out.println("Is Intern: " + isIntern);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E101", "Ravi Kumar", 45000);
        Employee intern = new Employee("E102", "Sneha Patel");

        permanent.printProfile();
        intern.printProfile();
    }
}
