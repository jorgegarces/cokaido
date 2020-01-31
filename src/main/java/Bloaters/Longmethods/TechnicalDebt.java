package Bloaters.Longmethods;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TechnicalDebt {
    private List<Issue> issues = new ArrayList<Issue>();
    private float total;
    private String lastIssueDate;

    public void fixed(float amount)
    {
        this.total = total - amount;
    }

    public void register(float effortManHours, String description)
    {
        Priority priority = getPriority(effortManHours);

        this.total = total + effortManHours;

        issues.add(new Issue(effortManHours, description, priority));

        updateLastIssue();
    }

    private void updateLastIssue() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        this.lastIssueDate = now.get(Calendar.DAY_OF_MONTH) + "/" + now.get(Calendar.MONTH) + "/" + now.get(Calendar.YEAR);
    }

    private Priority getPriority(float effortManHours) {
        checkIfOffBounds(effortManHours);

        if (effortManHours > 500) return Priority.Critical;
        if (effortManHours > 250) return Priority.High;
        if (effortManHours > 100) return Priority.Medium;

        return Priority.Low;
    }

    private void checkIfOffBounds(float effortManHours) {
        if (effortManHours > 1000 || effortManHours <= 0)
            throw new RuntimeException("Cannot register tech debt where effort is bigger than 1000 man hours to fix");
    }

    public Issue getLastIssue() {
        return issues.get((issues.size() - 1));
    }

    public String getLastIssueDate() {
        return lastIssueDate;
    }

    public float getTotal() {
        return total;
    }
}