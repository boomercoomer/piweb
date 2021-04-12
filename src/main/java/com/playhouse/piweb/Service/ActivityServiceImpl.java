package com.playhouse.piweb.Service;
import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Entities.Parent;
import com.playhouse.piweb.Repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepo activityRepo;
    @Override
    public List<Activity> findAll() {
        return activityRepo.findAll();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Activity Activity) {
        activityRepo.deleteById(Activity.getIdActivitie());
    }

    @Override
    public void deleteAll() {
        activityRepo.deleteAll();
    }

    @Override
    public Optional<Activity> findById(int id) {
        return activityRepo.findById(id);
    }

    @Override
    public Activity save(Activity Activity) {
        return activityRepo.save(Activity);
    }

    @Override
    public List<Activity> saveAll(List<Activity> list) {
        return activityRepo.saveAll(list);
    }

    @Override
    public Optional<Activity> findByType(String type) {
        return activityRepo.findByType(type);
    }

    @Override
    public Optional<Activity> findByKindergartenIdKinder(int id) {
        return activityRepo.findByKindergartenIdKinder(id);
    }

    @Override
    public void deleteByIdActivity(int id) {
        activityRepo.deleteById(id);
    }


}
