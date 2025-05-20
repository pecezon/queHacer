package com.queHacer.queHacer.ReviewPlace.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaceReviewDTO {
    private Long idPlace;
    private Integer idAppuser;
    private String description;
    private Double rating;
}
