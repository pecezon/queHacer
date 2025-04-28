package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Model.UpdatePlaceCommand;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlaceValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePlaceService implements Command<UpdatePlaceCommand, PlaceDTO> {

    private final PlaceRepository placeRepository;

    public UpdatePlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<PlaceDTO> execute(UpdatePlaceCommand input) {
        Optional<Place> placeOptional = placeRepository.findById(input.getId());
        if(placeOptional.isPresent()){
            Place place = input.getPlace();
            place.update(input);
            PlaceValidator.execute(place);
            placeRepository.save(place);
            return ResponseEntity.ok(new PlaceDTO(place));
        }
        throw new PlaceNotFoundException();
    }
}
