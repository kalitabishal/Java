import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] marks = new int[5];     
        int total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for student " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();   
            total += marks[i];              
        }

        double average = total / 5.0;      
        System.out.println("📘 Average grade: " + average);

        scanner.close();
    }
}