package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Event.validators.EventValidator;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateEventService implements Command<EventDTO, EventDTO> {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public CreateEventService(EventRepository eventRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<EventDTO> execute(EventDTO eventDTO) {
        AppUser creator = userRepository.findById(eventDTO.getId_creator())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Event event = new Event();


        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setMinPrice(eventDTO.getMinPrice());
        event.setMaxPrice(eventDTO.getMaxPrice());
        event.setInstagram(eventDTO.getInstagram());
        event.setFacebook(eventDTO.getFacebook());
        event.setWhatsapp(eventDTO.getWhatsapp());
        event.setTwitter(eventDTO.getTwitter());
        event.setStartDate(eventDTO.getStartDate());
        event.setEndDate(eventDTO.getEndDate());
        event.setStreetNumber(eventDTO.getStreetNumber());
        event.setStreet(eventDTO.getStreet());
        event.setZip_code(eventDTO.getZip_code());
        event.setCounty(eventDTO.getCounty());
        event.setCity(eventDTO.getCity());
        event.setCountry(eventDTO.getCountry());
        event.setPhone(eventDTO.getPhone());
        event.setSumReviews(event.getSumReviews() != null ? eventDTO.getSumReviews() : 0.0);
        event.setCantReviews(eventDTO.getCantReviews() != null ? eventDTO.getCantReviews() : 0L);
        event.setCreator(creator);

        EventValidator.execute(event);

        Event savedEvent = eventRepository.save(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EventDTO(savedEvent));
    }


}
