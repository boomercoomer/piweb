package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Feedback;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Repositories.ActivityRepo;
import com.playhouse.piweb.Repositories.EventRepo;
import com.playhouse.piweb.Repositories.FeedBackRepo;
import com.playhouse.piweb.Repositories.KindergartenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KindergartenServiceImpl implements KindergartenService {
    @Autowired
    KindergartenRepo kindergartenRepo;
    @Autowired
    FeedBackRepo feedBackRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    ActivityRepo activityRepo;

    @Override
    public List<Kindergarten> findAll() {
        return kindergartenRepo.findAll();
    }

    @Override
    public Long count() {
        return kindergartenRepo.count();
    }

    @Override
    public void delete(Kindergarten entity) {
kindergartenRepo.delete(entity);
    }

    @Override
    public void deleteAll() {
kindergartenRepo.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        kindergartenRepo.deleteById(id);
    }

    @Override
    public Optional<Kindergarten> findById(int id) {
        return kindergartenRepo.findById(id);
    }

    @Override
    public Kindergarten save(Kindergarten entity) {
        return kindergartenRepo.save(entity);
    }

    @Override
    public List<Kindergarten> saveAll(List<Kindergarten> list) {
        return kindergartenRepo.saveAll(list);
    }

     @Override
    public String postEvent(int idKinder, Event event) {
    Kindergarten kinder = kindergartenRepo.findById(idKinder).get();
     event.setKindergarten(kinder);
        eventRepo.save(event);
         kinder.getEvents().add(event);
         kinder = kindergartenRepo.save(kinder);
      return "Event added with succes !" + kinder.getNameKinder() +" "+event.getIdEvent();
        }

    @Override
    public String postActivity(int idKinder, Activity activity) {
        Kindergarten kinder = kindergartenRepo.findById(idKinder).get();
        activity.setKindergarten(kinder);
        activityRepo.save(activity);
        kinder.getActivities().add(activity);
        kinder = kindergartenRepo.save(kinder);
        return "Event added with succes !" + kinder.getNameKinder() +" "+activity.getIdActivitie();

    }

    @Override
    public Optional<Kindergarten> findByNameKinder(String name) {
        return kindergartenRepo.findByNameKinder(name);
    }

    @Override
    public float getStatistics(int id) {
        float totalScore =0f;
        totalScore += feedBackRepo.findByKindergartenIdKinder(id).stream().mapToLong(Feedback::getNote).sum();
        return  totalScore==0 ?  0 : totalScore / feedBackRepo.findByKindergartenIdKinder(id).size();

    }
}

