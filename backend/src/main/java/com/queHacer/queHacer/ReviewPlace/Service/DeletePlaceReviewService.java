package com.queHacer.queHacer.ReviewPlace.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewExceptions;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewNotFound;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import com.queHacer.queHacer.ReviewPlace.Repository.PlaceReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePlaceReviewService implements Command<PlaceReviewId, Void> {

    private final PlaceReviewRepository placeReviewRepository;
    private final PlaceRepository placeRepository;
    public DeletePlaceReviewService(PlaceReviewRepository placeReviewRepository, PlaceRepository placeRepository) {
        this.placeReviewRepository = placeReviewRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<Void> execute(PlaceReviewId input) {
        Optional<PlaceReview> temp = placeReviewRepository.findById(input);

        if(temp.isEmpty()){
            throw new PlaceReviewNotFound(PlaceReviewExceptions.REVIEW_NOT_FOUND.getMessage());
        }

        PlaceReview review = temp.get();
        Optional<Place> tempPlace = placeRepository.findById(review.getPlace().getId());
        if(tempPlace.isEmpty()){
            throw new PlaceNotFoundException();
        }
        Place place = tempPlace.get();
        place.setReviewCount(place.getReviewCount() - 1);
        place.setReviewSum(place.getReviewSum() - review.getRating());
        placeRepository.save(place);
        placeReviewRepository.deleteById(input);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
