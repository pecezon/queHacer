package com.queHacer.queHacer.ReviewEvent.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Repository.ReviewEventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllReviewEventService implements Query<Void, List<ReviewEventDTO>> {

    private final ReviewEventRepository reviewEventRepository;

    public GetAllReviewEventService(ReviewEventRepository reviewEventRepository) {
        this.reviewEventRepository = reviewEventRepository;
    }

    @Override
    public ResponseEntity<List<ReviewEventDTO>> execute(Void input) {
        List<ReviewEvent> reviewEvents = reviewEventRepository.findAll();
        List<ReviewEventDTO> reviewEventDTOS = reviewEvents.stream().map(ReviewEventDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(reviewEventDTOS);
    }
}
