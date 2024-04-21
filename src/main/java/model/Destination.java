package main.java.model;

import java.util.List;

public class Destination implements Printable {
    private String name;
    private List<Activity> activities;

    public Destination(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public void printDetails() {
        System.out.println("Destination: " + name);
        for (Activity activity : activities) {
            activity.printDetails();
        }
    }
}
