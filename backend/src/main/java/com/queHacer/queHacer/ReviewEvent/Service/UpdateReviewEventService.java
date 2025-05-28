package com.queHacer.queHacer.ReviewEvent.Service;


import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEvent;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Model.UpdateReviewEventCommand;
import com.queHacer.queHacer.ReviewEvent.Model.UpdateReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Repository.ReviewEventRepository;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotFoundException;
import com.queHacer.queHacer.ReviewEvent.Validators.ReviewEventValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateReviewEventService implements Command<UpdateReviewEventCommand, ReviewEventDTO> {

    private final ReviewEventRepository reviewEventRepository;

    public UpdateReviewEventService(ReviewEventRepository reviewEventRepository) {
        this.reviewEventRepository = reviewEventRepository;
    }

    @Override
    public ResponseEntity<ReviewEventDTO> execute(UpdateReviewEventCommand input) {

        Optional<ReviewEvent> reviewEventOptional = reviewEventRepository.findById(input.getId());

        if (reviewEventOptional.isPresent()){
            ReviewEvent reviewEvent = reviewEventOptional.get();
            UpdateReviewEventDTO updateReviewEventDTO = input.getUpdateReviewEventDTO();

            if (updateReviewEventDTO.getDescription() != null) reviewEvent.setDescription(updateReviewEventDTO.getDescription());
            if (updateReviewEventDTO.getRating() != null) reviewEvent.setRating(updateReviewEventDTO.getRating());

            ReviewEvent updated = reviewEventRepository.save(reviewEvent);

            //validator

            ReviewEventValidator.execute(updated);

            return ResponseEntity.ok(new ReviewEventDTO(updated));
        }

        throw new ReviewEventNotFoundException();
    }
}
