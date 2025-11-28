import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HabitTracker tracker = new HabitTracker();
        Scanner scanner = new Scanner(System.in);

        tracker.addHabit(new DailyHabit("Drink Water"));
        tracker.addHabit(new WeeklyHabit("Gym Workout"));

        while (true) {
            System.out.println("\n1. List Habits\n2. Mark Habit Done\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                tracker.listHabits();
            } else if (choice == 2) {
                System.out.print("Enter habit name to mark done: ");
                String name = scanner.nextLine();
                tracker.markHabitDone(name);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
    
