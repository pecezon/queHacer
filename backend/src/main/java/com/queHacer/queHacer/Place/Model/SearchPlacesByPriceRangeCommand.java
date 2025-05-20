package com.queHacer.queHacer.Place.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPlacesByPriceRangeCommand {
    private Float minPrice;
    private Float maxPrice;

    public SearchPlacesByPriceRangeCommand(Float minPrice, Float maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

}
