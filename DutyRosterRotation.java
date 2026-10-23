import java.util.Arrays;

public class DutyRosterRotation {
    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));
        System.out.println(Arrays.toString(rotateRoster(names, 7)));
    }
}
