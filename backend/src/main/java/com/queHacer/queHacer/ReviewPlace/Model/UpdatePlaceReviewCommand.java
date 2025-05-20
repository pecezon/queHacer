package com.queHacer.queHacer.ReviewPlace.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePlaceReviewCommand {

    private String description;
    private Double rating;
}
