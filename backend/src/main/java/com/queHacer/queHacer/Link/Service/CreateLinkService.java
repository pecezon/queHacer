package com.queHacer.queHacer.Link.Service;

import com.queHacer.queHacer.Event.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Link.Exceptions.InvalidLinkException;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Model.CreateLinkCommand;
import com.queHacer.queHacer.Link.Model.Link;
import com.queHacer.queHacer.Link.Model.LinkDTO;
import com.queHacer.queHacer.Link.Repository.LinkRepository;
import com.queHacer.queHacer.Link.Validators.LinkValidator;
import com.queHacer.queHacer.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreateLinkService implements Query<CreateLinkCommand, LinkDTO> {

    private final LinkRepository linkRepository;
    private final EventRepository eventRepository;


    public CreateLinkService(LinkRepository linkRepository, EventRepository eventRepository) {
        this.linkRepository = linkRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<LinkDTO> execute(CreateLinkCommand input) {
        Optional<Event> temp = eventRepository.findById(input.getEventId());

        if(temp.isEmpty()){
            throw new InvalidLinkException(LinkErrorMessages.EVENT_NOT_FOUND.getMessage());
        }
        LinkValidator.createValidation(input);
        Event event = temp.get();

        Link link = new Link();
        link.setUrl(input.getUrl());
        link.setAlt(input.getAlt());
        link.setEvent(event);

        //Save
        Link savedLink = linkRepository.save(link);

        LinkDTO response = new LinkDTO();
        response.setId(savedLink.getId());
        response.setUrl(savedLink.getUrl());
        response.setAlt(savedLink.getAlt());


        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
