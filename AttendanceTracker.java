import java.util.Arrays;

public class AttendanceTracker {
    static String attendanceSummary(int[] days) {
        int present = 0;
        int longest = 0;
        int current = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                current++;
                if (current > longest) {
                    longest = current;
                }
            } else {
                current = 0;
            }
        }
        return "Present: " + present + ", Longest streak: " + longest;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}
