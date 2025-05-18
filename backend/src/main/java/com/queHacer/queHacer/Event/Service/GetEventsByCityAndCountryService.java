package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Model.CityAndCountryCommand;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.EventSummaryDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Event.validators.EventValidator;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventsByCityAndCountryService implements Query<CityAndCountryCommand, List<EventSummaryDTO>> {

    private final EventRepository eventRepository;

    public GetEventsByCityAndCountryService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public ResponseEntity<List<EventSummaryDTO>> execute(CityAndCountryCommand input) {

        EventValidator.validateEventCityAndCountry(input);
        List<Event> events = eventRepository.findByCityAndCountry(input.getCity(),input.getCountry());
        List<EventSummaryDTO> eventSummaryDTOSDTOs = events.stream().map(EventSummaryDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(eventSummaryDTOSDTOs);
    }
}
