package main.java.service;

import main.java.model.Activity;
import main.java.repositories.Repository;

import java.util.List;

public class ActivityService implements Printable{

    private final Repository activityRepository;


    public ActivityService(Repository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public void addActivity(Activity activity) {
       activityRepository.add(activity);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.getAll();
    }

    @Override
    public void printDetails() {
        List<Activity> activities=activityRepository.getAll();
        for (Activity activity : activities) {
            activity.printDetails();
        }
    }

}
