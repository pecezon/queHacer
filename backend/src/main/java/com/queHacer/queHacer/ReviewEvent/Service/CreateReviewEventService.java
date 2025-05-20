package com.queHacer.queHacer.ReviewEvent.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Repository.ReviewEventRepository;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateReviewEventService implements Command<ReviewEventDTO, ReviewEventDTO> {

    private final ReviewEventRepository reviewEventRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public CreateReviewEventService(ReviewEventRepository reviewEventRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.reviewEventRepository = reviewEventRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<ReviewEventDTO> execute(ReviewEventDTO input) {

        AppUser appUser = userRepository.findById(input.getIdAppuser())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Event event = eventRepository.findById(input.getIdEvent()).
                orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        event.setSumReviews(event.getSumReviews() + input.getRating());
        event.setCantReviews(event.getCantReviews() + 1);
        eventRepository.save(event);

        ReviewEvent reviewEvent = new ReviewEvent();

        reviewEvent.setDescription(input.getDescription());
        reviewEvent.setRating(input.getRating());
        reviewEvent.setAppUser(appUser);
        reviewEvent.setEvent(event);


        //validacion
        ReviewEvent SavedReviewEvent = reviewEventRepository.save(reviewEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ReviewEventDTO(SavedReviewEvent));
    }
}
