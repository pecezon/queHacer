package com.queHacer.queHacer.Place.Model;

import lombok.Data;

@Data
public class UpdatePlaceDTO {
    private String name;
    private String description;
    private Long priceRange;
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
    private String menu;
    private String phoneNumber;
    private Long reviewCount;
    private Double reviewSum;
}
