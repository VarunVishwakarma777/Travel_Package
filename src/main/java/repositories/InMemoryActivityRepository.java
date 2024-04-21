package main.java.repositories;
import main.java.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class InMemoryActivityRepository implements Repository<Activity> {

    private final List<Activity> activities;

    public InMemoryActivityRepository() {
        this.activities = new ArrayList<>();
    }

    @Override
    public void add(Activity activity) {
        activities.add(activity);
    }


    @Override
    public List<Activity> getAll() {
        return activities;
    }
}
