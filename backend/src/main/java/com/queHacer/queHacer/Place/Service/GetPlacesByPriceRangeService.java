package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Model.SearchPlacesByPriceRangeCommand;
import com.queHacer.queHacer.Place.Model.SummaryPlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlacePriceValidator;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPlacesByPriceRangeService implements Query<SearchPlacesByPriceRangeCommand, List<SummaryPlaceDTO>> {
    public final PlaceRepository placeRepository;

    public GetPlacesByPriceRangeService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }
    @Override
    public ResponseEntity<List<SummaryPlaceDTO>> execute(SearchPlacesByPriceRangeCommand input) {
        PlacePriceValidator.execute(input);
        List<SummaryPlaceDTO> places = placeRepository.findPlacesByPriceRange(input.getMinPrice(), input.getMaxPrice()).stream().map(SummaryPlaceDTO::new).toList();
        return ResponseEntity.ok(places);
    }

}
