package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Agent;
import com.playhouse.piweb.Repositories.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgentServiceImpl implements AgentService {
    
    @Autowired
    AgentRepo agentRepo;
    @Override
    public List<Agent> findAll() {
        return agentRepo.findAll();
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public void delete(Agent agent) {
        agentRepo.deleteById(agent.getUserid());
    }

    @Override
    public void deleteById(int id) {
        agentRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        agentRepo.deleteAll();
    }

    @Override
    public Optional<Agent> findById(int id) {
        return agentRepo.findById(id);
    }

    @Override
    public Agent save(Agent agent) {
        return agentRepo.save(agent);
    }

    @Override
    public List<Agent> saveAll(List<Agent> list) {
        return agentRepo.saveAll(list);
    }

    @Override
    public Optional<Agent> findByFullName(String fullname) {
        return agentRepo.findByFirstNameOrLastName(fullname,fullname);
    }


}
