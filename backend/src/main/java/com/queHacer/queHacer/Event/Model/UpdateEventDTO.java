package com.queHacer.queHacer.Event.Model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateEventDTO {
    private String name;
    private String description;
    private Float minPrice;
    private Float maxPrice;
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
    private String phone;
    private Long sumReviews;
    private Double cantReviews;
}
