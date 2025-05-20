package com.queHacer.queHacer.Event.Model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDTO {
    private Integer id;
    private String name;
    private String description;
    private Float minPrice;
    private Float maxPrice;
    private String instagram;
    private String facebook;
    private String whatsapp;
    private String twitter;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String streetNumber;
    private String street;
    private String zip_code;
    private String county;
    private String city;
    private String country;
    private Integer id_creator;
    private String phone;
    private Double sumReviews;
    private Long cantReviews;


    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.minPrice = event.getMinPrice();
        this.maxPrice = event.getMaxPrice();
        this.instagram = event.getInstagram();
        this.facebook = event.getFacebook();
        this.whatsapp = event.getWhatsapp();
        this.twitter = event.getTwitter();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
        this.streetNumber = event.getStreetNumber();
        this.street = event.getStreet();
        this.zip_code = event.getZip_code();
        this.county = event.getCounty();
        this.city = event.getCity();
        this.country = event.getCountry();
        this.phone = event.getPhone();
        this.sumReviews = event.getSumReviews();
        this.cantReviews = event.getCantReviews();
        this.id_creator = event.getCreator() != null ? event.getCreator()
                .getId() : null;
    }
}
