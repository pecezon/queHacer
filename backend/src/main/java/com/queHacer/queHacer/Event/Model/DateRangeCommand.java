package com.queHacer.queHacer.Event.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
public class DateRangeCommand {

    private  LocalDate startDate;

    private  LocalDate endDate;

    private  String city;

    private  String country;

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

}
