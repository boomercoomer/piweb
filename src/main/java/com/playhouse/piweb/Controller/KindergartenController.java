package com.playhouse.piweb.Controller;


import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Entities.Event;
import com.playhouse.piweb.Entities.Feedback;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Service.FeedbackService;
import com.playhouse.piweb.Service.KindergartenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class KindergartenController {
    @Autowired
    private KindergartenService kindergartenService;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/kindergartens")
    public List<Kindergarten> findAll() {
        return this.kindergartenService.findAll();
    }


    @GetMapping ("/kindergartens/count")
    public Long count() {
        return kindergartenService.count();
    }

    @GetMapping("/kindergartens/search/name/{fullname}")
    public Optional<Kindergarten> findbyname(@PathVariable String fullname) {
        return kindergartenService.findByNameKinder(fullname);
    }
    @DeleteMapping("/kindergartens/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!kindergartenService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        kindergartenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/kindergartens/saveall")
    public List<Kindergarten> saveAll(@RequestBody List<Kindergarten> Kindergartenlist) {
        return kindergartenService.saveAll(Kindergartenlist);
    }

    @PutMapping("/kindergartens/edit/save")
    public Kindergarten save(@RequestBody Kindergarten Kindergarten) {
        return kindergartenService.save(Kindergarten);
    }


    @PostMapping("/kindergartens/postevent/{id}")
    public String postEvent(@RequestBody Event event , @PathVariable int id) {return kindergartenService.postEvent(id,event);}

    @PostMapping("/kindergartens/postactivity/{id}")
    public String postActivity(@RequestBody Activity activity , @PathVariable int id) {return kindergartenService.postActivity(id,activity);}

    @GetMapping("/kindergartens/search/{id}")
    public Optional<Kindergarten> getKindergarten(@PathVariable int id) {return kindergartenService.findById(id);}


    @PostMapping("/kindergartens/add")
    public Kindergarten addKindergarten(@RequestBody Kindergarten Kindergarten) {return kindergartenService.save(Kindergarten);}

    @GetMapping("/kindergartens/feedbacks/{id}")
    public List<Feedback> getFeedbacksByKinderId(@PathVariable int id) {
        return feedbackService.findByKinderId(id);
    }

    @GetMapping("/kindergartens/stats/{id}")
    public float getStats(@PathVariable int id) {
        return kindergartenService.getStatistics(id);
    }

}
