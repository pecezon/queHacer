package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Exceptions.UserNotFoundException;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetEventByCreatorIdService implements Query<Integer, List<EventDTO>> {

    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    public GetEventByCreatorIdService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<EventDTO>> execute(Integer input) {

        Optional<User> creator = userRepository.findById(input);

        if (creator.isPresent()){
            List<Event> events = eventRepository.findByCreatorId(input);
            List<EventDTO> eventDTOs = events.stream().map(EventDTO::new).toList();
            return ResponseEntity.status(HttpStatus.OK).body(eventDTOs);
        }

        throw new UserNotFoundException();
    }
}
