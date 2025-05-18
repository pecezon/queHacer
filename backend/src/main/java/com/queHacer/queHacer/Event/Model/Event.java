package com.queHacer.queHacer.Event.Model;

import com.queHacer.queHacer.User.Model.User;
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "minPrice")
    private Float minPrice;

    @Column(name = "maxPrice")
    private Float maxPrice;

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

    @Column(name="streetNumber")
    private String streetNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "county")
    private String county;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zip_code;


    // delete all my  events and then volver a implementar el dto en createevent

    @Column(name = "id_creator", nullable = false)
    private Integer id_creator;

    @Column(name = "phone")
    private String phone;

    @Column (name = "sumReviews")
    private Long sumReviews;
//cambiar valores
    @Column (name = "cantReviews")
    private Double cantReviews;

}
