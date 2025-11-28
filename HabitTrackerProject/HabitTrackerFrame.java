import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HabitTrackerFrame extends JFrame {

    private HabitTracker tracker;
    private DefaultListModel<String> habitListModel;
    private JList<String> habitJList;

    public HabitTrackerFrame(HabitTracker tracker) {
        this.tracker = tracker;

        setTitle("Habit Tracker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top Panel: Buttons
        JPanel topPanel = new JPanel();
        JButton addButton = new JButton("Add Habit");
        JButton markButton = new JButton("Mark Done");
        JButton resetButton = new JButton("Reset All");
        topPanel.add(addButton);
        topPanel.add(markButton);
        topPanel.add(resetButton);
        add(topPanel, BorderLayout.NORTH);

        // Center: Habit List
        habitListModel = new DefaultListModel<>();
        habitJList = new JList<>(habitListModel);
        JScrollPane scrollPane = new JScrollPane(habitJList);
        add(scrollPane, BorderLayout.CENTER);

        // Load habits into list
        refreshHabitList();

        // Button Actions
        addButton.addActionListener(e -> addHabitDialog());
        markButton.addActionListener(e -> markHabitDone());
        resetButton.addActionListener(e -> {
            tracker.resetHabitsIfNeeded();
            refreshHabitList();
        });

        setVisible(true);
    }

    private void refreshHabitList() {
        habitListModel.clear();
        for (Habit habit : tracker.getHabits()) {
            String status = habit.getName() + " | " + habit.getFrequency()
                    + " | Streak: " + habit.getStreak()
                    + " | Done Today: " + (habit.isDoneToday() ? "✅" : "❌");
            habitListModel.addElement(status);
        }
    }

    private void addHabitDialog() {
        String name = JOptionPane.showInputDialog(this, "Enter habit name:");
        if (name == null || name.isBlank()) return;

        String[] options = {"Daily", "Weekly"};
        int choice = JOptionPane.showOptionDialog(this, "Choose frequency:", "Frequency",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[0]);

        if (choice == 0) {
            tracker.addHabit(new DailyHabit(name));
        } else if (choice == 1) {
            tracker.addHabit(new WeeklyHabit(name));
        }

        refreshHabitList();
    }

    private void markHabitDone() {
        int selectedIndex = habitJList.getSelectedIndex();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Select a habit to mark as done.");
            return;
        }

        Habit habit = tracker.getHabits().get(selectedIndex);
        habit.markDoneToday();
        refreshHabitList();
    }
}
