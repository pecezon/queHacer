package com.queHacer.queHacer.Event.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity

@Data
@Table(name = "Events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "minPrice")
    private Long minPrice;

    @Column(name = "maxPrice")
    private Long maxPrice;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name="streetNnumber")
    private Integer streetNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private Integer zip_code;

    @Column(name = "county")
    private String county;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "id_creator")
    private Integer id_creator;

    @Column(name = "phone")
    private String phone;

    @Column (name = "sumReviews")
    private Long sumReviews;

    @Column (name = "cantReviews")
    private Double cantReviews;

}
