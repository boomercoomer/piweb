package com.playhouse.piweb.Controller;

import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

        @Autowired
        
        private EventService eventService;

        @GetMapping("/events")
        public List<Event> findAll() {
            return this.eventService.findAll();
        }


        @GetMapping ("/events/count")
        public Long count() {
            return eventService.count();
        }

        @GetMapping("/events/search/kindergarten/{id}")
        public Optional<Event> findbyKinderId(@PathVariable int id) {
            return this.eventService.findByKindergarten(id);
        }
        @DeleteMapping("/events/delete/{id}")
        public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
            if (!eventService.findById(id).isPresent())
            {
                return ResponseEntity.notFound().build();
            }
            eventService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    @GetMapping("/events/search/parent/{id}")
    public Optional<Event> findbyParentId(@PathVariable int id) {
        return this.eventService.findByParentId(id);
    }
        @PostMapping("/events/saveall")
        public List<Event> saveAll(@RequestBody List<Event> Eventlist) {
            return eventService.saveAll(Eventlist);
        }

        @PutMapping("/events/edit/save")
        public Event save(@RequestBody Event Event) {
            return eventService.save(Event);
        }
        @DeleteMapping("/events/deleteall")
        public String deleteAll(){eventService.deleteAll();
        return "All events are deleted";}

        @GetMapping("/events/search/{id}")
        public Optional<Event> getEvent(@PathVariable int id) {return eventService.findById(id);}
        @PostMapping("/events/add")
        public Event addEvent(@RequestBody Event Event) {return eventService.save(Event);}
}
