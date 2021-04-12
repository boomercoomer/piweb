package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Kindergarten;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAll();
    Long count();
    void delete(Event entity);
    void deleteAll();
    Optional<Event> findById(int id);
    Event save(Event entity);
    List<Event> saveAll(List<Event> list);
    Optional<Event> findByType(String type);
    Optional<Event> findByKindergarten(int id);
    Optional<Event> findByParentId(int id);
    void deleteById(int id);
}
