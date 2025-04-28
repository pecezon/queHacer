package com.queHacer.queHacer.Place.Model;

import com.queHacer.queHacer.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer priceRange;

    @Column(length = 255)
    private String instagram;

    @Column(length = 255)
    private String facebook;

    @Column(length = 255)
    private String whatsapp;

    @Column(length = 255)
    private String twitter;

    @Column(length = 10)
    private String number;

    @Column(nullable = false, length = 100)
    private String street;

    @Column(nullable = false, length = 10)
    private String cp;

    @Column(nullable = false, length = 100)
    private String county;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false,length = 100)
    private String country;

    @Column(name = "cant_Reviews")
    private Long reviewCount;

    @Column(name = "sum_Reviews")
    private Double reviewSum;

    @ManyToOne
    @JoinColumn(name = "id_creator", nullable = false) //FK
    private User creator;

    @Column(columnDefinition = "TEXT")
    private String menu;

    @Column(length = 20)
    private String phoneNumber;



    public void update(UpdatePlaceCommand command) {
        this.name = command.getPlace().getName();
        this.description = command.getPlace().getDescription();
        this.priceRange = command.getPlace().getPriceRange();
        this.instagram = command.getPlace().getInstagram();
        this.facebook = command.getPlace().getFacebook();
        this.whatsapp = command.getPlace().getWhatsapp();
        this.twitter = command.getPlace().getTwitter();
        this.number = command.getPlace().getNumber();
        this.street = command.getPlace().getStreet();
        this.cp = command.getPlace().getCp();
        this.county = command.getPlace().getCounty();
        this.city = command.getPlace().getCity();
        this.country = command.getPlace().getCountry();
        this.menu = command.getPlace().getMenu();
        this.phoneNumber = command.getPlace().getPhoneNumber();
    }


}
