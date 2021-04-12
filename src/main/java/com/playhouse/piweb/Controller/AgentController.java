package com.playhouse.piweb.Controller;

import com.playhouse.piweb.Entities.Agent;
import com.playhouse.piweb.Service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;

    @GetMapping("/agents")
    public List<Agent> findAll() {
        return this.agentService.findAll();
    }


    @GetMapping ("/agents/count")
    public Long count() {
        return agentService.count();
    }

    @GetMapping("/agents/search/name/{fullname}")
    public Optional<Agent> findbyname(@PathVariable String fullname) {
        return this.agentService.findByFullName(fullname);
    }
    @DeleteMapping("/agents/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!agentService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        agentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/agents/saveall")
    public List<Agent> saveAll(@RequestBody List<Agent> Agentlist) {
        return agentService.saveAll(Agentlist);
    }

    @PutMapping("/agents/edit/save")
    public Agent save(@RequestBody Agent Agent) {
        return agentService.save(Agent);
    }

    @GetMapping("/agents/search/{id}")
    public Optional<Agent> getAgent(@PathVariable int id) {return agentService.findById(id);}
    @PostMapping("/agents/add")
    public Agent addAgent(@RequestBody Agent Agent) {return agentService.save(Agent);}
}
