package com.queHacer.queHacer.PlaceSchedule.Service;


import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPlaceSchedulesByPlaceIdService implements Command<Long,List<PlaceScheduleDTO>>{
    private final PlaceScheduleRepository placeScheduleRepository;
    private final PlaceRepository placeRepository;

    public GetPlaceSchedulesByPlaceIdService(PlaceScheduleRepository placeScheduleRepository, PlaceRepository placeRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<PlaceScheduleDTO>> execute(Long input) {
        Optional<Place> placeOp = placeRepository.findById(input);
        if(placeOp.isEmpty()){
            throw new PlaceNotValidException(PlaceErrorMessages.PLACE_NOT_FOUND.getMessage());
        }
        List<PlaceScheduleDTO> schedules = placeScheduleRepository.findByPlaceId(input).stream().map(PlaceScheduleDTO::new).toList();
        return ResponseEntity.ok(schedules);
    }
}
