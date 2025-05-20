package com.queHacer.queHacer.PlaceSchedule.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceSchedule;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePlaceScheduleService implements Command<Long, Void> {
    private final PlaceScheduleRepository placeScheduleRepository;

    public DeletePlaceScheduleService(PlaceScheduleRepository placeScheduleRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long input) {
        Optional<PlaceSchedule> schedule = placeScheduleRepository.findById(input);
        if(schedule.isPresent()){
            placeScheduleRepository.deleteById(input);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.SCHEDULE_NOT_FOUND.getMessage());

    }
}
