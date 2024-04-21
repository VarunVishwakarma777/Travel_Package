package main.java.model;

public class Activity implements Printable {

    private String activityName;

    private String description;

    private double cost;

    private int capacity;

    public Activity(String activityName, String description, double cost, int capacity) {
        this.activityName = activityName;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }


    public String getActivityName() {
        return activityName;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void reduceCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }


    @Override
    public void printDetails() {
        System.out.println("Activity: " + activityName);
        System.out.println("Description: " + description);
        System.out.println("Cost: " + cost);
        System.out.println("Capacity: " + capacity);
    }

}
