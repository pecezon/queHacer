package com.queHacer.queHacer.PlaceSchedule.Model;

import com.queHacer.queHacer.Place.Model.Place;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "place_schedule")
public class PlaceSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_the_week", nullable = false)
    private DayOfTheWeek dayOfTheWeek;

    @Column(name = "opening")
    private LocalTime openingTime;

    @Column(name = "closing")
    private LocalTime closingTime;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
}
