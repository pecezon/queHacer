package com.queHacer.queHacer.Event.Model;

import com.queHacer.queHacer.User.Model.AppUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotNull(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotNull(message = "Description is required")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Minimum price is required")
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

    @NotNull(message = "Start date is required")
    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name="streetNumber")
    private String streetNumber;

    @NotNull(message = "Street is required")
    @Column(name = "street")
    private String street;

    @Column(name = "county")
    private String county;

    @NotNull(message = "City is required")
    @Column(name = "city")
    private String city;

    @NotNull(message = "Country is required")
    @Column(name = "country")
    private String country;

    @NotNull(message = "Zip code is required")
    @Size(max = 10)
    @Column(name = "zip_code")
    private String zip_code;


    @ManyToOne
    @JoinColumn (name = "id_creator", nullable = false)
    private AppUser creator;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, message = "Phone number must be 10 digits long at least")
    @Column(name = "phone")
    private String phone;

    @Column (name = "sumReviews")
    private Double sumReviews;
//cambiar valores
    @Column (name = "cantReviews")
    private Long cantReviews;

}
