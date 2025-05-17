package com.queHacer.queHacer.PlaceSchedule.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteSchedulesForPlaceService implements Command<Long, Void> {

    private final PlaceScheduleRepository placeScheduleRepository;
    private final PlaceRepository placeRepository;

    public DeleteSchedulesForPlaceService(PlaceScheduleRepository placeScheduleRepository, PlaceRepository placeRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long input) {
        Optional<Place> place = placeRepository.findById(input);
        if(place.isEmpty()){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_NOT_FOUND.getMessage());
        }
        placeScheduleRepository.deleteAllByPlaceId(input);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
