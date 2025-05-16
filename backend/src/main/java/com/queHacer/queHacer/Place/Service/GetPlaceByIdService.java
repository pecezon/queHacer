package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class GetPlaceByIdService implements Query<Long, PlaceDTO> {
    private final PlaceRepository placeRepository;

    public GetPlaceByIdService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<PlaceDTO> execute(Long input) {
        Place place = placeRepository.findById(input)
                .orElseThrow(PlaceNotFoundException::new);

        return ResponseEntity.ok(new PlaceDTO(place));
    }
}
