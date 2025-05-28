package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPlacesService implements Query<Void, List<PlaceDTO>> {
    private final PlaceRepository placeRepository;

    public GetAllPlacesService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<List<PlaceDTO>> execute(Void input) {
        List<Place> events = placeRepository.findAll();
        List<PlaceDTO> placeDTOS = events.stream().map(PlaceDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(placeDTOS);
    }
}
