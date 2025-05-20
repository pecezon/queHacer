package com.queHacer.queHacer.ReviewPlace.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceReviewDTO {
    private Long idPlace;
    private Integer idAppuser;
    private String description;
    private Double rating;

    public PlaceReviewDTO(PlaceReview saved) {
        this.idPlace = saved.getId().getIdPlace();
        this.idAppuser = saved.getId().getIdAppuser();
        this.description = saved.getDescription();
        this.rating = saved.getRating();
    }
}
