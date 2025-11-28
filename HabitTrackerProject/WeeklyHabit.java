import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeeklyHabit extends Habit {
    public WeeklyHabit(String name) {
        super(name, "Weekly");
    }

    @Override
    public boolean shouldReset() {
        if (lastCompleted == null) return true;

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int lastWeek = lastCompleted.get(weekFields.weekOfWeekBasedYear());
        int currentWeek = LocalDate.now().get(weekFields.weekOfWeekBasedYear());

        return currentWeek != lastWeek;
    }
}