
import java.util.Scanner;

public class Calculator {
    
    public static double add(double x, double y) {
        return x + y;
    }
    
    public static double subtract(double x, double y) {
        return x - y;
    }
    
    public static double divide(double x, double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return x / y;
    }
    
    public static double multiply(double x, double y) {
        return x * y;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select an operation:");
        System.out.println("1. ADD");
        System.out.println("2. SUBTRACT");
        System.out.println("3. DIVIDE");
        System.out.println("4. MULTIPLY");
        System.out.print("Enter your choice (1-4): ");
        
        int choice = scanner.nextInt();
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        String operation = "";
        
        switch (choice) {
            case 1:
                result = add(num1, num2);
                operation = "Addition";
                break;
            case 2:
                result = subtract(num1, num2);
                operation = "Subtraction";
                break;
            case 3:
                try {
                    result = divide(num1, num2);
                    operation = "Division";
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            case 4:
                result = multiply(num1, num2);
                operation = "Multiplication";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        System.out.printf("%s result: %.2f%n", operation, result);
    }
}