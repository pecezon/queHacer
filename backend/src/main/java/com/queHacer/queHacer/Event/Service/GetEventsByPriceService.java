package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.EventPriceCommand;
import com.queHacer.queHacer.Event.Model.EventSummaryDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEventsByPriceService implements Query<EventPriceCommand, List<EventSummaryDTO>> {

    private final EventRepository eventRepository;

    public GetEventsByPriceService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<List<EventSummaryDTO>> execute(EventPriceCommand input) {
        List<Event> events = eventRepository.findByPriceBetween(input.getMinPrice(), input.getMaxPrice(), input.getCity(), input.getCountry());

        List<EventSummaryDTO> eventSummaryDTOSDTOS = events.stream().map(EventSummaryDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(eventSummaryDTOSDTOS);
    }
}
