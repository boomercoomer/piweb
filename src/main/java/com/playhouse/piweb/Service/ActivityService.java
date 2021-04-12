package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Entities.Parent;

import java.util.List;
import java.util.Optional;

public interface ActivityService {
    List<Activity> findAll();
    Long count();
    void delete(Activity entity);
    void deleteAll();
    Optional<Activity> findById(int id);
    Activity save(Activity entity);
    List<Activity> saveAll(List<Activity> list);
    Optional<Activity> findByType(String type);
    Optional<Activity> findByKindergartenIdKinder(int id);
    void deleteByIdActivity(int id);
}
