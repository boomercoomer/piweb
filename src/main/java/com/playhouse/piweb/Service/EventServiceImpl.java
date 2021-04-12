package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepo eventRepo;
    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Event event) {
        eventRepo.deleteById(event.getIdEvent());
    }

    @Override
    public void deleteAll() {
        eventRepo.deleteAll();
    }

    @Override
    public Optional<Event> findById(int id) {
        return eventRepo.findById(id);
    }

    @Override
    public Event save(Event entity) {
        return eventRepo.save(entity);
    }

    @Override
    public List<Event> saveAll(List<Event> list) {
        return eventRepo.saveAll(list);
    }

    @Override
    public Optional<Event> findByType(String type) {
        return eventRepo.findByType(type);
    }

    @Override
    public Optional<Event> findByKindergarten(int id) {
        return eventRepo.findByKindergartenIdKinder(id);
    }

    @Override
    public Optional<Event> findByParentId(int id) {
        return eventRepo.findByParentIduser(id);
    }

    @Override
    public void deleteById(int id){
        eventRepo.deleteById(id);
    }


}
