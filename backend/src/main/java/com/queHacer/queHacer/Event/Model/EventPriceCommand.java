package com.queHacer.queHacer.Event.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventPriceCommand {
    private  Float minPrice;

    private  Float maxPrice;

    private  String city;

    private  String country;

    public EventPriceCommand(Float minPrice, Float maxPrice, String city, String country) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.city = city;
        this.country = country;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
