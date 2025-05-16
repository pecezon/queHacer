package com.queHacer.queHacer.PlaceSchedule.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleErrorMessages;
import com.queHacer.queHacer.PlaceSchedule.Exceptions.PlaceScheduleNotValidException;
import com.queHacer.queHacer.PlaceSchedule.Model.*;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import com.queHacer.queHacer.PlaceSchedule.Validators.PlaceScheduleValidators;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UpdatePlaceScheduleService implements Command<CreatePlaceSchedulesCommand, List<PlaceScheduleDTO>> {

    private final PlaceScheduleRepository placeScheduleRepository;
    private final PlaceRepository placeRepository;

    public UpdatePlaceScheduleService(PlaceScheduleRepository placeScheduleRepository, PlaceRepository placeRepository) {
        this.placeScheduleRepository = placeScheduleRepository;
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<PlaceScheduleDTO>> execute(CreatePlaceSchedulesCommand input) {
        List<CreatePlaceScheduleDTO> inputSchedules = input.getSchedules();
        Long placeId = input.getPlaceId();

        // Validate list
        PlaceScheduleValidators.validateScheduleList(inputSchedules);
        Place existingPlace = placeRepository.findById(placeId)
                .orElseThrow(() -> new PlaceScheduleNotValidException(
                        PlaceScheduleErrorMessages.SCHEDULE_DOES_NOT_BELONG_TO_PLACE.getMessage()
                ));

        // get existing schedules
        List<PlaceSchedule> existingSchedules = placeScheduleRepository.findByPlaceId(placeId);

        Map<DayOfTheWeek, PlaceSchedule> existingMap = existingSchedules.stream()
                .collect(Collectors.toMap(PlaceSchedule::getDayOfTheWeek, s -> s));

        List<PlaceSchedule> toSave = new ArrayList<>();

        for (CreatePlaceScheduleDTO dto : inputSchedules) {
            PlaceSchedule existing = existingMap.get(dto.getDayOfTheWeek());

            if (existing != null) {
                // if exists, save for update
                existing.setOpeningTime(dto.getOpeningTime());
                existing.setClosingTime(dto.getClosingTime());
                toSave.add(existing);
            } else {
                // id not, create and then save for update
                PlaceSchedule nuevo = new PlaceSchedule(
                        null,
                        dto.getDayOfTheWeek(),
                        dto.getOpeningTime(),
                        dto.getClosingTime(),
                        existingPlace
                );
                toSave.add(nuevo);
            }
        }


        List<PlaceScheduleDTO> output = placeScheduleRepository.saveAll(toSave).stream()
                .map(PlaceScheduleDTO::new)
                .toList();

        return ResponseEntity.ok(output);
    }
}
