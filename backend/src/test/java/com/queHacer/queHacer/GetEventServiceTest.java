package com.queHacer.queHacer;

import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.Event.Model.EventDTO;
import com.queHacer.queHacer.Event.Repository.EventRepository;
import com.queHacer.queHacer.Event.Service.GetEventService;
import com.queHacer.queHacer.User.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetEventServiceTest {

    @Mock //what to mock the response of ->  need this dependency to run the test
    private EventRepository eventRepository;

    @InjectMocks // the thing we are testing
    private GetEventService getEventService;

    @BeforeEach // things we need before  the test runs to set up properly
    public void setup(){
        // initializes the repo and the service
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_event_exists_when_get_event_service_return_event_dto(){

        User user = new User();
        user.setId(1);
        user.setName("test");

        //Given
        Event event = new Event();
        event.setId(12);
        event.setName("La cagada va en la taza");
        event.setDescription("Droguitas.com la mejor forma de conseguir lo que buscas.");
        event.setMinPrice(1f);
        event.setMaxPrice(2f);
        event.setInstagram("@motazaki");
        event.setFacebook("facebook.com/evento");
        event.setWhatsapp("1234567890");
        event.setTwitter("@motazaki");
        event.setStartDate(LocalDateTime.parse("2025-06-22T20:30:00"));
        event.setEndDate(LocalDateTime.parse("2025-06-22T23:30:00"));
        event.setStreetNumber("81271");
        event.setStreet("Bahía Vizcaino");
        event.setCounty("Moderna");
        event.setCity("Ensenada");
        event.setCountry("Mexico");
        event.setZip_code("81271");
        event.setCreator(user);
        event.setPhone("1234567890");
        event.setSumReviews(23.0);
        event.setCantReviews(21L);

        // this says 'when' but it's still setting up
        when(eventRepository.findById(12)).thenReturn(Optional.of(event));

        // when
        ResponseEntity<EventDTO> response = getEventService.execute(12);

        // then
        assertEquals(ResponseEntity.ok(new EventDTO(event)), response);
        //asserts the product repository was only called once
        verify(eventRepository, times(1)).findById(12);
    }

    @Test
    public void given_event_does_not_exist_when_get_event_service_throw_event_not_found_exception(){
        // given
        when(eventRepository.findById(12)). thenReturn(Optional.empty());

        //when & then
        assertThrows(EventNotFoundException.class, () -> getEventService.execute(12));
        verify(eventRepository, times(1)).findById(12);
    }
}
