package com.playhouse.piweb.Controller;


import com.playhouse.piweb.Entities.Activity;
import com.playhouse.piweb.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/activities")
    public List<Activity> findAll() {
        return this.activityService.findAll();
    }


    @GetMapping ("/activities/count")
    public Long count() {
        return activityService.count();
    }

    @GetMapping("/activities/search/kindergarten/{id}")
    public Optional<Activity> findbyKinderId(@PathVariable int id) {
        return this.activityService.findByKindergartenIdKinder(id);
    }
    @DeleteMapping("/activities/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id ) {
        if (!activityService.findById(id).isPresent())
        {
            return ResponseEntity.notFound().build();
        }
        activityService.deleteByIdActivity(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/activities/saveall")
    public List<Activity> saveAll(@RequestBody List<Activity> Activitylist) {
        return activityService.saveAll(Activitylist);
    }

    @PutMapping("/activities/edit/save")
    public Activity save(@RequestBody Activity Activity) {
        return activityService.save(Activity);
    }

    @GetMapping("/activities/search/{id}")
    public Optional<Activity> getActivity(@PathVariable int id) {return activityService.findById(id);}
    @PostMapping("/activities/add")
    public Activity addActivity(@RequestBody Activity Activity) {return activityService.save(Activity);}
}
