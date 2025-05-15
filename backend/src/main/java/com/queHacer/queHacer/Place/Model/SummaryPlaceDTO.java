package com.queHacer.queHacer.Place.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class  SummaryPlaceDTO {


    private Long id;
    private String name;
    private String description;
    private Long reviewCount;
    private Double reviewSum;
    private String mainImage;


    public SummaryPlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.description = place.getDescription();
        this.reviewCount = place.getReviewCount();
        this.reviewSum = place.getReviewSum();
        this.mainImage = place.getMainImage();

    }
}
