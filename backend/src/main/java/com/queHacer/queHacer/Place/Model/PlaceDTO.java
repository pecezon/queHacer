package com.queHacer.queHacer.Place.Model;

import lombok.Data;

@Data
public class PlaceDTO {

    private Long id;
    private String name;
    private String description;
    private Integer priceRange;
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

    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.description = place.getDescription();
        this.priceRange = place.getPriceRange();
        this.instagram = place.getInstagram();
        this.facebook = place.getFacebook();
        this.whatsapp = place.getWhatsapp();
        this.twitter = place.getTwitter();
        this.streetNumber = place.getNumber();
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
    }
}