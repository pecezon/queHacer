package com.queHacer.queHacer.Event.Model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DateRangeCommand {

    private final LocalDate startDate;

    private  LocalDate endDate;

    private final String city;

    private final String country;

    public DateRangeCommand(LocalDate startDate, LocalDate endDate, String city, String country) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.city = city;
        this.country = country;
    }

    public DateRangeCommand(LocalDate startDate, String city, String country) {
        this.startDate = startDate;
        this.city = city;
        this.country = country;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
