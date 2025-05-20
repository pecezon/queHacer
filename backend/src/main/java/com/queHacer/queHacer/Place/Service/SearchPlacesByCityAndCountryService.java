package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Model.SearchPlaceByCityAndCountryCommand;
import com.queHacer.queHacer.Place.Model.SummaryPlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlaceValidator;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPlacesByCityAndCountryService implements Query<SearchPlaceByCityAndCountryCommand, List<SummaryPlaceDTO>> {
    private final PlaceRepository placeRepository;

    public SearchPlacesByCityAndCountryService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<SummaryPlaceDTO>> execute(SearchPlaceByCityAndCountryCommand input) {
        PlaceValidator.validateCityAndCountry(input);

        return ResponseEntity.ok(placeRepository.findByCityAndCountryIgnoreCase(
                        input.getCity(),
                        input.getCountry()
                ).stream()
                .map(SummaryPlaceDTO::new)
                .toList());
    }
}
