import java.util.Scanner;

public class Problem08_GradeAssignment {
    static char grade(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int marks = sc.nextInt();
            System.out.println("Grade " + grade(marks));
        }
        sc.close();
    }
}
