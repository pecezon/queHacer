package com.queHacer.queHacer.Event.Model;

import lombok.Getter;

@Getter
public class EventPriceCommand {
    private final Long minPrice;

    private final Long maxPrice;

    private final String city;

    private final String country;

    public EventPriceCommand(Long minPrice, Long maxPrice, String city, String country) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.city = city;
        this.country = country;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public Long getMaxPrice() {
        return maxPrice;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
