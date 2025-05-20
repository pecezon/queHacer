package com.queHacer.queHacer.ReviewEvent.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventSummaryDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotValidException;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Repository.ReviewEventRepository;
import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class GetAllReviewsOfASingleEventService implements Query<Integer, List<ReviewEventDTO>> {

    private final ReviewEventRepository reviewEventRepository;

    private final EventRepository eventRepository;

    public GetAllReviewsOfASingleEventService(ReviewEventRepository reviewEventRepository, EventRepository eventRepository) {
        this.reviewEventRepository = reviewEventRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<List<ReviewEventDTO>> execute(Integer input) {

        Optional<Event> eventOptional = eventRepository.findById(input);

        if (eventOptional.isPresent()){
            List<ReviewEvent> reviewEvents = reviewEventRepository.findByEventId(input);

            List<ReviewEventDTO> reviewEventDTOS = reviewEvents.stream().map(ReviewEventDTO::new).toList();

            return ResponseEntity.status(HttpStatus.OK).body(reviewEventDTOS);
        }
        return null;
    }
}
