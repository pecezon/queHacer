package com.queHacer.queHacer.Event.Controller;

import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Exceptions.EventNotValidException;
import com.queHacer.queHacer.Event.Model.*;
import com.queHacer.queHacer.Event.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.ErrorResponse;
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

    private final GetEventsByDateRangeService getEventsByDateRangeService;

    private final GetEventsByPriceService getEventsByPriceService;

    public EventController(CreateEventService createEventService,
                           GetEventsService getEventsService,
                           UpdateEventService updateEventService,
                           DeleteEventService deleteEventService,
                           GetEventService getEventService, SearchEventService searchEventService, GetEventByCreatorIdService getEventByCreatorIdService, GetEventsByCityAndCountryService getEventsByCityAndCountryService, GetEventsByCertainDate getEventsByCertainDate, GetEventsByDateRangeService getEventsByDateRangeService, GetEventsByPriceService getEventsByPriceService) {
        this.createEventService = createEventService;
        this.getEventsService = getEventsService;
        this.updateEventService = updateEventService;
        this.deleteEventService = deleteEventService;
        this.getEventService = getEventService;
        this.searchEventService = searchEventService;
        this.getEventByCreatorIdService = getEventByCreatorIdService;
        this.getEventsByCityAndCountryService = getEventsByCityAndCountryService;
        this.getEventsByCertainDate = getEventsByCertainDate;
        this.getEventsByDateRangeService = getEventsByDateRangeService;
        this.getEventsByPriceService = getEventsByPriceService;
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('EVENT_CREATOR')")
    @PostMapping("/event")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO){
        return createEventService.execute(eventDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/events")
    public ResponseEntity<List<EventDTO>> getEvents(){
        return getEventsService.execute(null);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/event/{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Integer id){
        return getEventService.execute(id);
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/event/{id}")
    public ResponseEntity<EventDTO> updateEvent(@PathVariable Integer id, @RequestBody UpdateEventDTO event){
        return updateEventService.execute(new UpdateEventCommand(id, event));
    }

    @PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @DeleteMapping("/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Integer id){
        return deleteEventService.execute(id);
    }

    @GetMapping("/event/search")
    public ResponseEntity<List<EventSummaryDTO>> searchEventByName(@RequestParam String name){
        return searchEventService.execute(name);
    }

    @GetMapping("/event/creator")
    public ResponseEntity<List<EventSummaryDTO>> getEventsByCreatorId(@RequestParam Integer creatorId){
        return getEventByCreatorIdService.execute(creatorId);
    }

    @GetMapping("/event/search/city-country")
    public ResponseEntity<List<EventSummaryDTO>> getEventsByCity(@RequestParam String city, @RequestParam String country){
        return getEventsByCityAndCountryService.execute(new CityAndCountryCommand(city,country));
    }

    @GetMapping("/event/search/by-date")
    public ResponseEntity<List<EventSummaryDTO>> getEventsByDay(@RequestParam LocalDate date, @RequestParam String city, @RequestParam String country){
        return getEventsByCertainDate.execute(new DateRangeCommand(date, city, country));
    }

    @GetMapping("/event/search/by-date-range")
    public ResponseEntity<List<EventSummaryDTO>> getEventsBetween(@RequestParam LocalDate startDay, @RequestParam (required = false) LocalDate endDay, @RequestParam String city, @RequestParam String country){
        return getEventsByDateRangeService.execute(new DateRangeCommand(startDay,endDay,city,country));

        //fehca de end tiene que ser menor a la de inicio
    }

    @GetMapping("/event/search/by-price")
    public ResponseEntity<List<EventSummaryDTO>> getEventsBetweenPrice(@RequestParam (required = false) Float minPrice, @RequestParam (required = false) Float maxPrice, @RequestParam String city, @RequestParam String country){ //escribir bien maxPrice
        return getEventsByPriceService.execute(new EventPriceCommand(minPrice,maxPrice, city, country));
        //validar ciudad y precio max menor a max , si no se escribe alguno se toman valores aparte
    }

    @ExceptionHandler(EventNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EventErrorResponse handleEventNotFoundException(EventNotFoundException e){
        return new EventErrorResponse(e.getMessage());
    }

    @ExceptionHandler(EventNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EventErrorResponse handleEventNotValidException(EventNotValidException e){
        return new EventErrorResponse(e.getMessage());
    }


}
