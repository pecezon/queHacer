package com.queHacer.queHacer.PlaceSchedule.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceSchedule;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetScheduleByIdService implements Command<Long, PlaceScheduleDTO> {

    private final PlaceScheduleRepository placeScheduleRepository;

    public GetScheduleByIdService(PlaceScheduleRepository placeScheduleRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
    }

    @Override
    public ResponseEntity<PlaceScheduleDTO> execute(Long input) {
        Optional<PlaceSchedule> schedule = placeScheduleRepository.findById(input);
        if(schedule.isEmpty()){
            throw new PlaceScheduleNotValidException(PlaceScheduleErrorMessages.SCHEDULE_NOT_FOUND.getMessage());
        }
        PlaceSchedule scheduleCorrect = schedule.get();
        PlaceScheduleDTO output = new PlaceScheduleDTO(scheduleCorrect);

        return ResponseEntity.ok(output);
    }
}
