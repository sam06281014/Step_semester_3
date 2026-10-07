// Problem 3: College Fee Counter
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface UsesBus {
    double TRANSPORT_FEE = 12000.0; // written once, shared by every bus-using student type

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();
}

class DayScholar extends Student implements UsesBus {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student implements UsesBus {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }
}

public class Q3_CollegeFeeCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().trim().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];

            Student student;
            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }
            students.add(student);
        }

        double totalCollected = 0;
        for (Student student : students) {
            double fee = student.calculateTuition();
            if (student instanceof UsesBus) {
                fee += ((UsesBus) student).getTransportFee();
            }
            totalCollected += fee;
            System.out.printf("%s: %.2f%n", student.name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
        sc.close();
    }
}
