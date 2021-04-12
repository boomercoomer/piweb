package com.playhouse.piweb.Service;



import com.playhouse.piweb.Entities.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    List<Feedback> findAll();
    Long count();
    void delete(Feedback entity);
    void deleteAll();
    void deleteById(int id);
    Optional<Feedback> findById(int id);
    Feedback save(Feedback entity);
    List<Feedback> saveAll(List<Feedback> list);
    List<Feedback> findByKinderId(int id);
    String addFeedback(Feedback feedback ,int id );

}
