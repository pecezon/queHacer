package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPlaceService implements Query<String, List<PlaceDTO>> {

    private final PlaceRepository placeRepository;

    public SearchPlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<PlaceDTO>> execute(String input) {
        return ResponseEntity.ok(placeRepository.findPlaceByNameOrDescriptionContaining(input).stream().map(PlaceDTO::new).toList());
    }
}
