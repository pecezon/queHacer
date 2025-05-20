package com.queHacer.queHacer.ReviewPlace.Service;

import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewExceptions;
import com.queHacer.queHacer.ReviewPlace.Exceptions.PlaceReviewNotFound;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import com.queHacer.queHacer.ReviewPlace.Repository.PlaceReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class GetPlaceReviewByIdService implements Query<PlaceReviewId, PlaceReviewDTO> {

    private final PlaceReviewRepository placeReviewRepository;

    public GetPlaceReviewByIdService(PlaceReviewRepository placeReviewRepository) {
        this.placeReviewRepository = placeReviewRepository;
    }

    @Override
    public ResponseEntity<PlaceReviewDTO> execute(PlaceReviewId input) {
        Optional<PlaceReview> temp = placeReviewRepository.findById(input);
        if(temp.isEmpty()){
            throw new PlaceReviewNotFound(PlaceReviewExceptions.REVIEW_NOT_FOUND.getMessage());
        }
        PlaceReview review = temp.get();


        return ResponseEntity.ok(new PlaceReviewDTO(review));
    }
}
