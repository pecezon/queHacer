package com.queHacer.queHacer.Place.Model;

import lombok.Getter;

@Getter
public class SearchPlaceByCityAndCountryCommand {
    private final String city;
    private final String country;

    public SearchPlaceByCityAndCountryCommand(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
