package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Kindergarten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepo extends JpaRepository<Event,Integer> {
    Optional<Event> findByType(String type);
    Optional<Event> findByKindergartenIdKinder(int id);
    Optional<Event> findByParentIduser(int id);
}
