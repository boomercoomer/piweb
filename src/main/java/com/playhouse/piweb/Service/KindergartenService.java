package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Kindergarten;

import java.util.List;
import java.util.Optional;

public interface KindergartenService {
    List<Kindergarten> findAll();
    Long count();
    void delete(Kindergarten entity);
    void deleteAll();
    void deleteById(int id);
    Optional<Kindergarten> findById(int id);
    Kindergarten save(Kindergarten kindergarten);
    List<Kindergarten> saveAll(List<Kindergarten> list);
     String postEvent(int idKinder, Event event);
    String postActivity(int idKinder , Activity activity);
    Optional<Kindergarten> findByNameKinder(String name);
    float getStatistics(int id);
}