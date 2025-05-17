package com.queHacer.queHacer.Place.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceDTO {

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


    public PlaceDTO(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.description = place.getDescription();
        //this.priceRange = place.getPriceRange();
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
        this.mainImage = place.getMainImage();
    }
}