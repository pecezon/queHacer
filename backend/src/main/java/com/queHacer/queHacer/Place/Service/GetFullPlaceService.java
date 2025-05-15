package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.DisplayFullPlaceInfoDTO;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import com.queHacer.queHacer.PlaceSchedule.Repository.PlaceScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFullPlaceService implements Command<Long, DisplayFullPlaceInfoDTO> {
    private final PlaceRepository placeRepository;
    private final PlaceScheduleRepository placeScheduleRepository;

    public GetFullPlaceService(PlaceRepository placeRepository, PlaceScheduleRepository placeScheduleRepository) {
        this.placeRepository = placeRepository;
        this.placeScheduleRepository = placeScheduleRepository;
    }

    @Override
    public ResponseEntity<DisplayFullPlaceInfoDTO> execute(Long id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(PlaceNotFoundException::new);

        List<PlaceScheduleDTO> schedules = placeScheduleRepository.findByPlaceId(id)
                .stream()
                .map(PlaceScheduleDTO::new)
                .toList();

        DisplayFullPlaceInfoDTO dto = new DisplayFullPlaceInfoDTO(place, schedules);
        return ResponseEntity.ok(dto);
    }
}