package com.queHacer.queHacer.ReviewEvent.Model;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.User.Model.AppUser;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews_events")
public class ReviewEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_appuser")
    private AppUser appUser;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

}
