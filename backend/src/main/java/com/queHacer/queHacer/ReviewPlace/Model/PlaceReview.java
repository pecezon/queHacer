package com.queHacer.queHacer.ReviewPlace.Model;

import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import com.queHacer.queHacer.User.Model.AppUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "place_review")
@AllArgsConstructor
@NoArgsConstructor
public class PlaceReview {

    @EmbeddedId
    private PlaceReviewId id;

    @ManyToOne
    @MapsId("idPlace")
    @JoinColumn(name = "id_place")
    private Place place;

    @ManyToOne
    @MapsId("idAppuser")
    @JoinColumn(name = "id_appuser")
    private AppUser appUser;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Double rating;

}
