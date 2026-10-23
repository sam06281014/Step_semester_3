import java.util.Scanner;

public class Problem02_WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            if (word.equals(reversed)) {
                System.out.println(word + " - palindrome");
            } else {
                System.out.println(reversed + " - not a palindrome");
            }
        }
        sc.close();
    }
}
