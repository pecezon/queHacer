package com.queHacer.queHacer.Event.Controller;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Model.UpdateEventCommand;
import com.queHacer.queHacer.Event.Model.UpdateEventDTO;
import com.queHacer.queHacer.Event.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private final CreateEventService createEventService;

    private final GetEventsService getEventsService;

    private final UpdateEventService updateEventService;

    private final DeleteEventService deleteEventService;

    private final GetEventService getEventService;

    private final SearchEventService searchEventService;

    public EventController(CreateEventService createEventService,
                           GetEventsService getEventsService,
                           UpdateEventService updateEventService,
                           DeleteEventService deleteEventService,
                           GetEventService getEventService, SearchEventService searchEventService) {
        this.createEventService = createEventService;
        this.getEventsService = getEventsService;
        this.updateEventService = updateEventService;
        this.deleteEventService = deleteEventService;
        this.getEventService = getEventService;
        this.searchEventService = searchEventService;
    }


    @PostMapping("/event")
    public ResponseEntity<EventDTO> createEvent(@RequestBody Event event){
        return createEventService.execute(event);
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getEvents(){
        return getEventsService.execute(null);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Integer id){
        return getEventService.execute(id);
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Integer id, @RequestBody UpdateEventDTO event){
        return updateEventService.execute(new UpdateEventCommand(id, event));
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id){
        return deleteEventService.execute(id);
    }

    @GetMapping("/event/search")
    public ResponseEntity<List<EventDTO>> searchEventByName(@RequestParam String name){
        return searchEventService.execute(name);
    }
}
