package com.queHacer.queHacer.Link.Service;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Link.Exceptions.InvalidLinkException;
import com.queHacer.queHacer.Link.Exceptions.LinkErrorMessages;
import com.queHacer.queHacer.Link.Exceptions.LinkNotFoundException;
import com.queHacer.queHacer.Link.Model.LinkDTO;
import com.queHacer.queHacer.Link.Repository.LinkRepository;
import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GetLinksForEventService implements Query<Integer,List<LinkDTO>> {

    private final LinkRepository linkRepository;
    private final EventRepository eventRepository;

    public GetLinksForEventService(LinkRepository linkRepository, EventRepository eventRepository) {
        this.linkRepository = linkRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public ResponseEntity<List<LinkDTO>> execute(Integer input) {
        Optional<Event> optional = eventRepository.findById(input);
        if(optional.isEmpty()){
            throw new InvalidLinkException(LinkErrorMessages.EVENT_NOT_FOUND.getMessage());
        }
        List<LinkDTO> response = linkRepository.findByEvent_Id(input).stream()
                .map(LinkDTO::new)
                .toList();

        return ResponseEntity.ok(response);
    }
}
