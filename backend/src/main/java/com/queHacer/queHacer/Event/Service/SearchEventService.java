package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.EventSummaryDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchEventService implements Query<String, List<EventSummaryDTO>> {

    private final EventRepository eventRepository;


    public SearchEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<List<EventSummaryDTO>> execute(String input) {
        return ResponseEntity.ok(eventRepository.findByName(input)
                .stream()
                .map(EventSummaryDTO::new)
                .toList()
        );
    }
}
