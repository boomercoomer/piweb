package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parent> findAll();
    Long count();
    void delete(Parent entity);
    void deleteAll();
    Optional<Parent> findById(int id);
    Parent save(Parent entity);
    List<Parent> saveAll(List<Parent> list);
    String postEvent(int parentid , Event event , int idkinder);
    Optional<Parent> findByFirstNameOrLastName(String firstName, String lastName);
    void deleteById(int id);

}
