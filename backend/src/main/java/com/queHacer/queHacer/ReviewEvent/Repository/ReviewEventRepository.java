package com.queHacer.queHacer.ReviewEvent.Repository;

import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewEventRepository extends JpaRepository<ReviewEvent, ReviewEventId> {


    List<ReviewEvent> findByEventId(Integer idEvent);
}
