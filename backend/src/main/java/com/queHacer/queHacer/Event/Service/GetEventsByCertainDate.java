package com.queHacer.queHacer.Event.Service;


import com.queHacer.queHacer.Event.Model.DateRangeCommand;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.EventSummaryDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Event.validators.DateRangeValidator;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class GetEventsByCertainDate implements Query<DateRangeCommand, List<EventSummaryDTO>> {

    private final EventRepository eventRepository;

    public GetEventsByCertainDate(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public ResponseEntity<List<EventSummaryDTO>> execute(DateRangeCommand input) {

        DateRangeValidator.execute(input);

        LocalDateTime startOfDay= input.getStartDate().atStartOfDay();
        LocalDateTime endOfDay = input.getStartDate().atTime(LocalTime.MAX);

        List<Event> events = eventRepository.findByStartDateBetween(startOfDay,endOfDay, input.getCity(), input.getCountry());
        List<EventSummaryDTO> eventSummaryDTOSDTOS = events.stream().map(EventSummaryDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(eventSummaryDTOSDTOS);
    }
}
