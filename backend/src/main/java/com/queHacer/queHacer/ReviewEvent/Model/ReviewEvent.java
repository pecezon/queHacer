package com.queHacer.queHacer.ReviewEvent.Model;

import com.queHacer.queHacer.Event.Model.Event;
import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import com.queHacer.queHacer.User.Model.AppUser;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews_events")
public class ReviewEvent {

    @EmbeddedId
    private ReviewEventId id;

    @ManyToOne
    @MapsId("idEvent") // nombre del campo en ReviewEventId
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne
    @MapsId("idAppuser") // nombre del campo en ReviewEventId
    @JoinColumn(name = "id_appuser")
    private AppUser appUser;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

}
