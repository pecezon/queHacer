package com.queHacer.queHacer.Place.Headers;

import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.User.Model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceHeaderController {
 @GetMapping("/header-place")
    public String getRegionalResponse(@RequestHeader(required= false, defaultValue = "MEX") String region){
     if(region.equals("US")) return "McDonalds bbq";
     if(region.equals("MEX")) return "Taco burrito";

     return "COuntry not supported";
 }
 @GetMapping(value = "/header/place", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Place> getPlace(){
     User creator = new User();
     creator.setId(1);
     creator.setName("testUser");

     Place place = new Place();
     place.setId(1L);
     place.setName("Café del Bosque");
     place.setDescription("Un café escondido entre árboles, con wifi y repostería artesanal.");
     place.setMinPrice(100.0f);
     place.setMaxPrice(200.0f);
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

     return ResponseEntity.ok(place);
 }
}
