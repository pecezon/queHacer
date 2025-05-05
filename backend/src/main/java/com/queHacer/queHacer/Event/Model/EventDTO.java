package com.queHacer.queHacer.Event.Model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventDTO {
    private Integer id;
    private String name;
    private String description;
    private Long minPrice;
    private Long maxPrice;
    private String instagram;
    private String facebook;
    private String whatsapp;
    private String twitter;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer streetNumber;
    private String street;
    private Integer zip_code;
    private String county;
    private String city;
    private String country;
    private Integer id_creator;
    private String phone;
    private Long sumReviews;
    private Double cantReviews;


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
        this.id_creator = event.getId_creator();
        this.phone = event.getPhone();
        this.sumReviews = event.getSumReviews();
        this.cantReviews = event.getCantReviews();
    }
}
