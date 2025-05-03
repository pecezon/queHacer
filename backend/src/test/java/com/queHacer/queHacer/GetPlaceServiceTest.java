package com.queHacer.queHacer;


import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Service.GetPlaceByIdService;
import com.queHacer.queHacer.User.Model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetPlaceServiceTest {
    @Mock //What to mock
    private PlaceRepository placeRepository;

    @InjectMocks//Thing to test
    private GetPlaceByIdService getPlaceByIdService;

    @BeforeEach//setup before running the test
    public void setup(){
        //Initializes the repository & service
        MockitoAnnotations.openMocks(this);

    }

    @Test
    public void given_place_exists_when_get_place_service_returns_place_dto(){
        //Given
        User creator = new User();
        creator.setId(1);
        creator.setName("testUser");

        Place place = new Place();
        place.setId(1L);
        place.setName("Café del Bosque");
        place.setDescription("Un café escondido entre árboles, con wifi y repostería artesanal.");
        place.setPriceRange(2L);
        place.setInstagram("@cafedelbosque");
        place.setFacebook("facebook.com/cafedelbosque");
        place.setWhatsapp("1234567890");
        place.setTwitter("@bosquecafe");
        place.setStreetNumber("123");
        place.setStreet("Avenida Principal");
        place.setCp("22800");
        place.setCounty("Ensenada Centro");
        place.setCity("Ensenada");
        place.setCountry("México");
        place.setReviewCount(23L);
        place.setReviewSum(91.5);
        place.setCreator(creator);
        place.setMenu("Café, té, repostería artesanal, snacks.");
        place.setPhoneNumber("6461234567");

        when(placeRepository.findById(1L)).thenReturn(Optional.of(place));

        //When
        ResponseEntity<PlaceDTO> response = getPlaceByIdService.execute(1L);


        //Then
        assertEquals(ResponseEntity.ok(new PlaceDTO(place)),response);
        verify(placeRepository, times(1)).findById(1L);
    }

    @Test
    public void given_place_not_found_when_get_place_service_throw_product_not_found_exception(){

        when(placeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PlaceNotFoundException.class, () -> getPlaceByIdService.execute(1L));
        verify(placeRepository, times(1)).findById(1L);
    }
}
