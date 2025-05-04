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
    private Integer minPrice;

    @Column(name = "maxPrice")
    private Integer maxPrice;

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

    @Column(name="number")
    private int number;

    @Column(name = "street")
    private String street;

    @Column(name = "zip_code")
    private int zip_code;

    @Column(name = "county")
    private String county;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "id_creator")
    private int id_creator;

    @Column(name = "phone")
    private String phone;

    @Column (name = "sumReviews")
    private int sumReviews;

    @Column (name = "cantReviews")
    private int cantReviews;

}
