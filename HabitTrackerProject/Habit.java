import java.time.LocalDate;

public class Habit {
    private String name;
    private String frequency; // "Daily / Weekly"
    private int streak;
    protected LocalDate lastCompleted;

    public Habit(String name, String frequency) {
        this.name = name;
        this.frequency = frequency;
        this.streak = 0;
        this.lastCompleted = null;
    }

    public void markDoneToday() {
        LocalDate today = LocalDate.now();
        if (!today.equals(lastCompleted)) {
            streak++;
            lastCompleted = today;
            System.out.println("Habit marked as done: " + name);
        } else {
            System.out.println("You already completed this habit today!");
        }
    }

    public boolean isDoneToday() {
        return LocalDate.now().equals(lastCompleted);
    }

    public String getName() {
        return name;
    }

    public String getFrequency() {
        return frequency;
    }

    public int getStreak() {
        return streak;
    }

    public void printStatus() {
        System.out.println("Habit: " + name + " | Frequency: " + frequency +
                " | Streak: " + streak + " | Done Today? " + (isDoneToday() ? "✅" : "❌"));
    }
    public boolean shouldReset(){
        //Default logic 
        return false;
    }
}
