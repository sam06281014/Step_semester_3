import java.util.Arrays;

public class Problem04_InPlaceReversal {
    public static void main(String[] args) {
        int[] tokens = {11, 22, 33, 44};
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(tokens));
    }
}
