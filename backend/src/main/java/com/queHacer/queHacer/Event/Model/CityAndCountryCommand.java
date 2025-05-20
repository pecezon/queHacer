package com.queHacer.queHacer.Event.Model;


import lombok.Getter;

@Getter
public class CityAndCountryCommand {
    private final String city;
    private final String country;

    public CityAndCountryCommand(String city, String country) {
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
