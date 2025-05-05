package com.queHacer.queHacer.Event.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.UpdateEventCommand;
import com.queHacer.queHacer.Event.Model.UpdateEventDTO;
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
            Event event = eventOptional.get();
            UpdateEventDTO updateEventDTO = command.getUpdateEventDTO();

            if (updateEventDTO.getName() != null) event.setName(updateEventDTO.getName());
            if (updateEventDTO.getDescription() != null) event.setDescription(updateEventDTO.getDescription());
            if (updateEventDTO.getMinPrice() != null) event.setMinPrice(updateEventDTO.getMinPrice());
            if (updateEventDTO.getMaxPrice() != null) event.setMaxPrice(updateEventDTO.getMaxPrice());
            if (updateEventDTO.getInstagram() != null) event.setInstagram(updateEventDTO.getInstagram());
            if (updateEventDTO.getFacebook() != null) event.setFacebook(updateEventDTO.getFacebook());
            if (updateEventDTO.getWhatsapp() != null) event.setWhatsapp(updateEventDTO.getWhatsapp());
            if (updateEventDTO.getTwitter() != null) event.setTwitter(updateEventDTO.getTwitter());
            if (updateEventDTO.getStartDate() != null) event.setStartDate(updateEventDTO.getStartDate());
            if (updateEventDTO.getEndDate() != null) event.setEndDate(updateEventDTO.getEndDate());
            if (updateEventDTO.getStreetNumber() != null) event.setStreetNumber(updateEventDTO.getStreetNumber());
            if (updateEventDTO.getStreet() != null) event.setStreet(updateEventDTO.getStreet());
            if (updateEventDTO.getZip_code() != null) event.setZip_code(updateEventDTO.getZip_code());
            if (updateEventDTO.getCounty() != null) event.setCounty(updateEventDTO.getCounty());
            if (updateEventDTO.getCity() != null) event.setCity(updateEventDTO.getCity());
            if (updateEventDTO.getCountry() != null) event.setCountry(updateEventDTO.getCountry());
            if (updateEventDTO.getPhone() != null) event.setPhone(updateEventDTO.getPhone());
            if (updateEventDTO.getSumReviews() != null) event.setSumReviews(updateEventDTO.getSumReviews());
            if (updateEventDTO.getCantReviews() != null)event.setCantReviews(updateEventDTO.getCantReviews());

            Event updated = eventRepository.save(event);
            return ResponseEntity.ok(new EventDTO(updated));
        }

        //Not Found Exception
        return null;
    }
}
