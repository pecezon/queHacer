package com.queHacer.queHacer.ReviewPlace.PlaceReviewId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlaceReviewId implements Serializable {

    @Column(name = "id_place")
    private Long idPlace;

    @Column(name = "id_appuser")
    private Integer idAppuser;

    public PlaceReviewId(Integer idPlace, Integer idAppuser) {

    }
}
