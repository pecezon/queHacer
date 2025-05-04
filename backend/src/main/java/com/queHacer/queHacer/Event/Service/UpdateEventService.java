package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.UpdateEventCommand;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateEventService implements Command<UpdateEventCommand, EventDTO> {

    private final EventRepository eventRepository;

    public UpdateEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<EventDTO> execute(UpdateEventCommand command) {
        Optional<Event> eventOptional = eventRepository.findById(command.getId());

        //make each case
        if (eventOptional.isPresent()){
            Event event = command.getEvent();
            event.setId(command.getId());
            eventRepository.save(event);
            return ResponseEntity.ok(new EventDTO(event));
        }

        //Not Found Exception
        return null;
    }
}
