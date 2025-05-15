package com.queHacer.queHacer.Place.Model;


import com.queHacer.queHacer.PlaceSchedule.Model.PlaceScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class DisplayFullPlaceInfoDTO {

    private Long id;
    private String name;
    private String description;

    private Float minPrice;
    private Float maxPrice;

    private String instagram;
    private String facebook;
    private String whatsapp;
    private String twitter;

    private String streetNumber;
    private String street;
    private String cp;
    private String county;
    private String city;
    private String country;

    private Long reviewCount;
    private Double reviewSum;

    private Integer creatorId;
    private String menu;
    private String phoneNumber;
    private String mainImage;

    private List<PlaceScheduleDTO> schedule;

    public DisplayFullPlaceInfoDTO(Place place, List<PlaceScheduleDTO> schedule) {
        this.id = place.getId();
        this.name = place.getName();
        this.description = place.getDescription();
        this.minPrice = place.getMinPrice();
        this.maxPrice = place.getMaxPrice();
        this.instagram = place.getInstagram();
        this.facebook = place.getFacebook();
        this.whatsapp = place.getWhatsapp();
        this.twitter = place.getTwitter();
        this.streetNumber = place.getStreetNumber();
        this.street = place.getStreet();
        this.cp = place.getCp();
        this.county = place.getCounty();
        this.city = place.getCity();
        this.country = place.getCountry();
        this.reviewCount = place.getReviewCount();
        this.reviewSum = place.getReviewSum();
        this.menu = place.getMenu();
        this.phoneNumber = place.getPhoneNumber();
        this.creatorId = place.getCreator() != null ? place.getCreator().getId() : null;
        this.schedule = schedule;
        this.mainImage = place.getMainImage();
    }
}