package com.queHacer.queHacer.ReviewPlace.Model;

import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlaceReviewDTO {
    private PlaceReviewId id;
    private UpdatePlaceReviewCommand updatePlaceReviewCommand;

}
