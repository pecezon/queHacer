package com.queHacer.queHacer.Place.Model;

import com.queHacer.queHacer.User.Model.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    //@Column(name = "price_range")
    //private Long priceRange;
    @Column(name = "min-price")
    private Float minPrice;

    @Column(name = "max-price")
    private Float maxPrice;

    @Column
    private String instagram;

    @Column
    private String facebook;

    @Column
    private String whatsapp;

    @Column
    private String twitter;

    @Column(length = 10, name = "street_number")
    private String streetNumber;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false, length = 10)
    private String cp;

    @Column(nullable = false)
    private String county;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(name = "review_count")
    private Long reviewCount;

    @Column(name = "review_sum")
    private Double reviewSum;

    @Column(name = "main_image")
    private String mainImage;

    @ManyToOne
    @JoinColumn(name = "id_creator", nullable = false) //FK
    private AppUser creator;

    @Column(columnDefinition = "TEXT")
    private String menu;

    @Column(name = "phone_number",length = 20)
    private String phoneNumber;

}
