package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteEventService implements Command<Integer, Void> {

    private final EventRepository eventRepository;

    public DeleteEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Event> eventOptional = eventRepository.findById(id);

        if(eventOptional.isPresent()){
            eventRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


        throw new EventNotFoundException();
    }
}
