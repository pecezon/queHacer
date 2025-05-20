package com.queHacer.queHacer.ReviewPlace.Repository;

import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceReviewRepository extends JpaRepository<PlaceReview, PlaceReviewId> {
    List<PlaceReview> findByPlaceId(Long placeId);
}
