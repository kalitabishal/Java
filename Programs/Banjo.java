package Java.Programs;

public class Banjo {
    public static String areYouPlayingBanjo(String name) {
        // Check if the first character is 'R' or 'r'
        // charAt is part of the String Library that helps in picking the position of char in a String
        if (name.charAt(0) == 'R' || name.charAt(0) == 'r') {
            return name + " plays banjo";
        } else {
            return name + " does not play banjo";
        }
    }

    // Example 
    public static void main(String[] args) {
        System.out.println(areYouPlayingBanjo("Rick"));  
        System.out.println(areYouPlayingBanjo("Marty")); 
    }
}
