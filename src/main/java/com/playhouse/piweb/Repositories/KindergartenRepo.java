package com.playhouse.piweb.Repositories;


import com.playhouse.piweb.Entities.Agent;
import com.playhouse.piweb.Entities.Kindergarten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KindergartenRepo extends JpaRepository<Kindergarten,Integer> {
    Optional<Kindergarten> findByNameKinder(String name);

}
