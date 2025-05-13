package com.queHacer.queHacer.Event.Service;


import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class GetEventsByCertainDate implements Query<LocalDate, List<EventDTO>> {

    private final EventRepository eventRepository;

    public GetEventsByCertainDate(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    public ResponseEntity<List<EventDTO>> execute(LocalDate input) {
        LocalDateTime startOfDay= input.atStartOfDay();
        LocalDateTime endOfDay = input.atTime(LocalTime.MAX);

        List<Event> events = eventRepository.findByStartDateBetween(startOfDay,endOfDay);
        List<EventDTO> eventDTOS = events.stream().map(EventDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(eventDTOS);
    }
}
