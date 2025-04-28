package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlaceValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceService implements Command<Place, PlaceDTO> {

    private final PlaceRepository repository;
    public CreatePlaceService(PlaceRepository repository){ this.repository = repository;}

    @Override
    public ResponseEntity<PlaceDTO> execute(Place place) {
        PlaceValidator.execute(place);
        Place savedPlace = repository.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PlaceDTO(savedPlace));
    }
}
