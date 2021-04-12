package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends JpaRepository<Child,Integer> {
}
