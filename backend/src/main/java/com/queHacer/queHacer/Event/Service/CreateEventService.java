package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Event.Exceptions.EventNotValidException;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Event.validators.EventValidator;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Repository.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CreateEventService implements Command<Event, EventDTO> {
    private final EventRepository eventRepository;

    public CreateEventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<EventDTO> execute(Event event) {


        EventValidator.execute(event);

        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EventDTO(savedEvent));
    }


}
