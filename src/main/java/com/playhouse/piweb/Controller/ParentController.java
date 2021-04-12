package com.playhouse.piweb.Controller;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Parent;
import com.playhouse.piweb.Service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ParentController {
    @Autowired
    private ParentService parentService;

    @GetMapping("/parents")
    public List<Parent> findAll() {
        return this.parentService.findAll();
    }


    @GetMapping ("/parents/count")
    public Long count() {
        return parentService.count();
    }

    @GetMapping("/parents/search/name/{fullname}")
    public Optional<Parent> findbyname(@PathVariable String fullname) {
        return parentService.findByFirstNameOrLastName(fullname,fullname);
    }
    @DeleteMapping("/parents/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!parentService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        parentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/parents/postevent/{idparent}/{idkinder}")
    public String postEvent(@RequestBody Event event , @PathVariable("idparent") int idparent , @PathVariable("idkinder") int idkinder ) {return parentService.postEvent(idparent,event,idkinder);}
    @PostMapping("/parents/saveall")
    public List<Parent> saveAll(@RequestBody List<Parent> Parentlist) {
        return parentService.saveAll(Parentlist);
    }

    @PutMapping("/parents/edit/save")
    public Parent save(@RequestBody Parent Parent) {
        return parentService.save(Parent);
    }

    @GetMapping("/parents/search/{id}")
    public Optional<Parent> getParent(@PathVariable int id) {return parentService.findById(id);}
    @PostMapping("/parents/add")
    public Parent addParent(@RequestBody Parent Parent) {return parentService.save(Parent);}
}
