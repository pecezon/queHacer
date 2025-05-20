package com.queHacer.queHacer.ReviewEvent.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Repository.ReviewEventRepository;
import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteReviewEventService implements Command<ReviewEventId, Void> {

    private final ReviewEventRepository reviewEventRepository;

    public DeleteReviewEventService(ReviewEventRepository reviewEventRepository) {
        this.reviewEventRepository = reviewEventRepository;
    }


    @Override
    public ResponseEntity<Void> execute(ReviewEventId input) {
        Optional<ReviewEvent> reviewEventOptional = reviewEventRepository.findById(input);

        if(reviewEventOptional.isPresent()){
            reviewEventRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


        throw new ReviewEventNotFoundException();
    }
}
