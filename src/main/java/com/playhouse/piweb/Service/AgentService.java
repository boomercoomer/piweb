package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Agent;
import com.playhouse.piweb.Entities.Event;

import java.util.List;
import java.util.Optional;

public interface AgentService {
    List<Agent> findAll();
    Long count();
    void delete(Agent entity);
    void deleteById(int id);
    void deleteAll();
    Optional<Agent> findById(int id);
    Agent save(Agent entity);
    List<Agent> saveAll(List<Agent> list);
    Optional<Agent> findByFullName(String fullname);
}
