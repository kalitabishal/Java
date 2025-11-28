import java.util.ArrayList;

public class HabitTracker {
    private ArrayList<Habit> habits;

    public HabitTracker() {
        habits = new ArrayList<>();
    }

    public void addHabit(Habit habit) {
        habits.add(habit);
        System.out.println("Added habit: " + habit.getName());
    }

    public void listHabits() {
        if (habits.isEmpty()) {
            System.out.println("No habits yet.");
            return;
        }
        for (Habit habit : habits) {
            habit.printStatus();
        }
    }

    public void markHabitDone(String name) {
        for (Habit habit : habits) {
            if (habit.getName().equalsIgnoreCase(name)) {
                habit.markDoneToday();
                return;
            }
        }
        System.out.println("Habit not found: " + name);
    }
}
