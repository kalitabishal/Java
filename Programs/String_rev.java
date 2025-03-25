package Java.Programs;
import java.util.Scanner;

public class String_rev {
    public static String reverse(String str) {
        char [] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;
        }
        return new String(chars);
    }
    public static void main(String[] args) {
       System.out.println("Enter a String");
       Scanner stringScanner = new Scanner(System.in);
        String original = stringScanner.next();
        String reversed = reverse(original);
        System.out.println("Original:" + original);
        System.out.println("Reversed: " + reversed);
    }
}
