package com.queHacer.queHacer.ReviewPlace.Service;

import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Repository.PlaceReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetAllReviewsForPlace implements Query<Long, List<PlaceReviewDTO>> {
    private final PlaceReviewRepository placeReviewRepository;

    public GetAllReviewsForPlace(PlaceReviewRepository placeReviewRepository) {
        this.placeReviewRepository = placeReviewRepository;
    }

    @Override
    public ResponseEntity<List<PlaceReviewDTO>> execute(Long input) {
        List<PlaceReview> reviews = placeReviewRepository.findByPlaceId(input);

        List<PlaceReviewDTO> dtoList = reviews.stream()
                .map(PlaceReviewDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }
}
