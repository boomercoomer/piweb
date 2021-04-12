package com.playhouse.piweb.Repositories;

import com.playhouse.piweb.Entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedBackRepo extends JpaRepository<Feedback,Integer> {
    List<Feedback> findByKindergartenIdKinder(int id);
}
