package Java.Programs;
public class PalindromeChecker {
    public boolean isPalindrome(String text) {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        
        String reversedText = String_rev.reverse(cleanedText);

        return cleanedText.equals(reversedText);
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        
        System.out.println(checker.isPalindrome("Madam"));
        System.out.println(checker.isPalindrome("Hello"));         
        System.out.println(checker.isPalindrome("A man a plan"));   
        System.out.println(checker.isPalindrome("racecar"));        
    }
}