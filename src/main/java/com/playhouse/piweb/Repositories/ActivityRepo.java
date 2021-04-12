package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ActivityRepo extends JpaRepository<Activity,Integer> {
    Optional<Activity> findByType(String type);
    Optional<Activity> findByKindergartenIdKinder(int id);
}
