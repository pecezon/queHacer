package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePlaceService implements Command<Long , Void>{

    private final PlaceRepository placeRepository;

    public DeletePlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long input) {
        Optional<Place> place = placeRepository.findById(input);
        if(place.isPresent()){
            placeRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new PlaceNotFoundException();
    }
}
