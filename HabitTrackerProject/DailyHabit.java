import java.time.LocalDate;

public class DailyHabit  extends Habit{
    public DailyHabit(String name) {
        super(name, "Daily");
    }
    @Override
    public boolean shouldReset() {
        return lastCompleted == null || !lastCompleted.equals(LocalDate.now());
    }
}
