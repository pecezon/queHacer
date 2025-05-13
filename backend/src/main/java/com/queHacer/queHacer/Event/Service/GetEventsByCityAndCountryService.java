package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Model.CityAndCountryCommand;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventsByCityAndCountryService implements Query<CityAndCountryCommand, List<EventDTO>> {

    private final EventRepository eventRepository;

    public GetEventsByCityAndCountryService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public ResponseEntity<List<EventDTO>> execute(CityAndCountryCommand input) {

        List<Event> events = eventRepository.findByCityAndCountry(input.getCity(),input.getCountry());
        List<EventDTO> eventDTOs = events.stream().map(EventDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(eventDTOs);
    }
}
