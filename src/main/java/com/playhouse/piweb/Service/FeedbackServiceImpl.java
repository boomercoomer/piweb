package com.playhouse.piweb.Service;

import com.playhouse.piweb.Entities.Feedback;
import com.playhouse.piweb.Entities.Kindergarten;
import com.playhouse.piweb.Repositories.FeedBackRepo;
import com.playhouse.piweb.Repositories.KindergartenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedBackRepo feedBackRepo;
    @Autowired
    KindergartenRepo kindergartenRepo;

    @Override
    public List<Feedback> findAll() {
        return feedBackRepo.findAll();
    }

    @Override
    public Long count() {
        return feedBackRepo.count();
    }

    @Override
    public void delete(Feedback entity) {
        feedBackRepo.delete(entity);
    }

    @Override
    public void deleteAll() {
feedBackRepo.deleteAll();
    }

    @Override
    public void deleteById(int id) {
        feedBackRepo.deleteById(id);
    }

    @Override
    public Optional<Feedback> findById(int id) {
        return feedBackRepo.findById(id);
    }

    @Override
    public Feedback save(Feedback entity) {
        System.out.println(entity);
        return feedBackRepo.save(entity);
    }

    @Override
    public List<Feedback> saveAll(List<Feedback> list) {
        return feedBackRepo.saveAll(list);
    }

    @Override
    public List<Feedback> findByKinderId(int id) {
        return feedBackRepo.findByKindergartenIdKinder(id);
    }

    @Override
    public String addFeedback(Feedback feedback, int id) {
        Kindergarten kinder = kindergartenRepo.findById(id).get();
        feedback.setKindergarten(kinder);
        feedBackRepo.save(feedback);
        kinder.getFeedbacks().add(feedback);
        kinder = kindergartenRepo.save(kinder);
        return "Feedback added with succes to kindergarten : " + kinder.getNameKinder() +", feedback's ID is : "+feedback.getIdFeedback();
    }


}
