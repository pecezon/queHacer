package com.queHacer.queHacer.Event.Controller;

import com.queHacer.queHacer.Event.Model.*;
import com.queHacer.queHacer.Event.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    private final CreateEventService createEventService;

    private final GetEventsService getEventsService;

    private final UpdateEventService updateEventService;

    private final DeleteEventService deleteEventService;

    private final GetEventService getEventService;

    private final SearchEventService searchEventService;

    private final GetEventByCreatorIdService getEventByCreatorIdService;


    private final GetEventsByCityAndCountryService getEventsByCityAndCountryService;

    private final GetEventsByCertainDate getEventsByCertainDate;

    public EventController(CreateEventService createEventService,
                           GetEventsService getEventsService,
                           UpdateEventService updateEventService,
                           DeleteEventService deleteEventService,
                           GetEventService getEventService, SearchEventService searchEventService, GetEventByCreatorIdService getEventByCreatorIdService, GetEventsByCityAndCountryService getEventsByCityAndCountryService, GetEventsByCertainDate getEventsByCertainDate) {
        this.createEventService = createEventService;
        this.getEventsService = getEventsService;
        this.updateEventService = updateEventService;
        this.deleteEventService = deleteEventService;
        this.getEventService = getEventService;
        this.searchEventService = searchEventService;
        this.getEventByCreatorIdService = getEventByCreatorIdService;
        this.getEventsByCityAndCountryService = getEventsByCityAndCountryService;
        this.getEventsByCertainDate = getEventsByCertainDate;
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

    @GetMapping("/event/creator")
    public ResponseEntity<List<EventDTO>> getEventsByCreatorId(@RequestParam Integer creatorId){
        return getEventByCreatorIdService.execute(creatorId);
    }


    @GetMapping("/event/search/city-country")
    public ResponseEntity<List<EventDTO>> getEventsByCity(@RequestParam String city, @RequestParam String country){
        return getEventsByCityAndCountryService.execute(new CityAndCountryCommand(city,country));
    }

    @GetMapping("/event/search/by-date")
    public ResponseEntity<List<EventDTO>> getEventsByDay(@RequestParam LocalDate date){
        return getEventsByCertainDate.execute(date);
    }
}
