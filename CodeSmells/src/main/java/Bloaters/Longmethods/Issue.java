package Bloaters.Longmethods;

public class Issue {
    private float effortManHours;
    private String description;
    private Priority priority;

    public Issue(float effortManHours, String description) {
        this.effortManHours = effortManHours;
        this.description = description;
    }

    public Issue(float effortManHours, String description, Priority priority) {
        this(effortManHours,description);
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }

}
