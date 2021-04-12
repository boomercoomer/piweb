package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepo extends JpaRepository<Parent,Integer> {
    Optional<Parent> findByFirstNameOrLastName(String firstName, String lastName);
}
