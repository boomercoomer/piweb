package com.playhouse.piweb.Service;


import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Entities.Parent;
import com.playhouse.piweb.Repositories.EventRepo;
import com.playhouse.piweb.Repositories.KindergartenRepo;
import com.playhouse.piweb.Repositories.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    KindergartenRepo kindergartenRepo;
    @Autowired
    ParentRepo parentRepo;
    @Autowired
    EventRepo eventRepo;

    @Override
    public List<Parent> findAll() {
        return parentRepo.findAll();
    }

    @Override
    public Long count() {
        return parentRepo.count();
    }

    @Override
    public void delete(Parent entity) {
        parentRepo.delete(entity);
    }

    @Override
    public void deleteAll() {
        parentRepo.deleteAll();
    }

    @Override
    public Optional<Parent> findById(int id) {
        return parentRepo.findById(id);
    }

    @Override
    public Parent save(Parent entity) {
        return parentRepo.save(entity);
    }

    @Override
    public List<Parent> saveAll(List<Parent> list) {
        return parentRepo.saveAll(list);
    }

    @Override
    public String postEvent(int idparent, Event event,int idkinder) {
        Parent parent = parentRepo.findById(idparent).get();
        Kindergarten kinder = kindergartenRepo.findById(idkinder).get();
        event.setKindergarten(kinder);
        event.setParent(parent);
        eventRepo.save(event);
        parent.getEvents().add(event);
        kinder.getEvents().add(event);
        return "Event added with succes! By : " + parent.getFirstName() +" at the kindergarten : "+kinder.getNameKinder()+ " event id is : "+event.getIdEvent();
    }


    @Override
    public Optional<Parent> findByFirstNameOrLastName(String firstName, String lastName) {
        return parentRepo.findByFirstNameOrLastName(firstName,lastName);
    }

    @Override
    public void deleteById(int id) {
        parentRepo.deleteById(id);
    }

}
