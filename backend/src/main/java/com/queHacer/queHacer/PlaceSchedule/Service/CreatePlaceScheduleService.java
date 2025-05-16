package com.queHacer.queHacer.PlaceSchedule.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.CreatePlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Model.CreatePlaceSchedulesCommand;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceSchedule;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import com.queHacer.queHacer.PlaceSchedule.Validators.PlaceScheduleValidators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreatePlaceScheduleService implements Command <CreatePlaceSchedulesCommand, List<PlaceScheduleDTO> >{
    private final PlaceScheduleRepository placeScheduleRepository;
    private final PlaceRepository placeRepository;

    public CreatePlaceScheduleService(PlaceScheduleRepository placeScheduleRepository, PlaceRepository placeRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<PlaceScheduleDTO>> execute(CreatePlaceSchedulesCommand input) {
        List<CreatePlaceScheduleDTO> schedules = input.getSchedules();
        Long placeId = input.getPlaceId();

        if (schedules == null || schedules.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(List.of());
        }

        PlaceScheduleValidators.validateScheduleList(schedules);

        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> new PlaceScheduleNotValidException(
                        PlaceScheduleErrorMessages.SCHEDULE_DOES_NOT_BELONG_TO_PLACE.getMessage()));

        List<PlaceSchedule> toSave = schedules.stream()
                .map(dto -> new PlaceSchedule(null, dto.getDayOfTheWeek(), dto.getOpeningTime(), dto.getClosingTime(), place))
                .toList();

        List<PlaceScheduleDTO> output = placeScheduleRepository.saveAll(toSave)
                .stream().map(PlaceScheduleDTO::new).toList();

        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
}
