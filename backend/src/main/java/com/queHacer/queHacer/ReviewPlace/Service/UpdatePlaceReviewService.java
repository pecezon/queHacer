package com.queHacer.queHacer.ReviewPlace.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.ReviewPlace.Exceptions.InvalidPlaceReviewException;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewExceptions;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewNotFound;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Model.UpdatePlaceReviewCommand;
import com.queHacer.queHacer.ReviewPlace.Model.UpdatePlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Repository.PlaceReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePlaceReviewService implements Command<UpdatePlaceReviewDTO, PlaceReviewDTO> {

    private final PlaceReviewRepository placeReviewRepository;

    public UpdatePlaceReviewService(PlaceReviewRepository placeReviewRepository) {
        this.placeReviewRepository = placeReviewRepository;
    }

    @Override
    public ResponseEntity<PlaceReviewDTO> execute(UpdatePlaceReviewDTO input) {
        Optional<PlaceReview> temp = placeReviewRepository.findById(input.getId());
        if(temp.isEmpty()){
            throw new PlaceReviewNotFound(PlaceReviewExceptions.REVIEW_NOT_FOUND.getMessage());
        }

        UpdatePlaceReviewCommand command = input.getUpdatePlaceReviewCommand();

        if (command.getRating() != null && (command.getRating() < 0 || command.getRating() > 5)) {
            throw new InvalidPlaceReviewException(PlaceReviewExceptions.INVALID_RATING.getMessage());
        }

        PlaceReview review = temp.get();

        if(command.getDescription() != null) review.setDescription(command.getDescription());
        if(command.getRating() != null) review.setRating(command.getRating());

        placeReviewRepository.save(review);

        return ResponseEntity.ok(new PlaceReviewDTO(review));
    }
}
