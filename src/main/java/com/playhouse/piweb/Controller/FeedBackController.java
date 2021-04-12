package com.playhouse.piweb.Controller;


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
public class FeedBackController {
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private KindergartenService kindergartenService;

    @GetMapping("/feedbacks")
    public List<Feedback> findAll() {
        return this.feedbackService.findAll();
    }


    @GetMapping ("/feedbacks/count")
    public Long count() {
        return feedbackService.count();
    }

    @DeleteMapping("/feedbacks/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!feedbackService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        feedbackService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/feedbacks/saveall")
    public List<Feedback> saveAll(@RequestBody List<Feedback> Feedbacklist) {
        return feedbackService.saveAll(Feedbacklist);
    }

    @PutMapping("/feedbacks/edit/save")
    public Feedback save(@RequestBody Feedback Feedback) {
        return feedbackService.save(Feedback);
    }

    @GetMapping("/feedbacks/search/{id}")
    public Optional<Feedback> getFeedback(@PathVariable int id) {return feedbackService.findById(id);}
    @PostMapping("/feedbacks/add/{id}")
    public String addFeedback(@RequestBody Feedback feedback ,@PathVariable int id) {
        return feedbackService.addFeedback(feedback ,id );}



}
