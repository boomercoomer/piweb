package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepo extends JpaRepository<Agent,Integer> {
    Optional<Agent> findByFirstNameOrLastName(String firstName, String lastName);
}
