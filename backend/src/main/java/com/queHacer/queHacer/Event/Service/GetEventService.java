package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetEventService implements Query<Integer, EventDTO> {

    private final EventRepository eventRepository;

    public GetEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<EventDTO> execute(Integer input) {
        Optional<Event> eventOptional = eventRepository.findById(input);

        if (eventOptional.isPresent()){
            return ResponseEntity.ok(new EventDTO(eventOptional.get()));
        }

        throw new EventNotFoundException();
    }
}
