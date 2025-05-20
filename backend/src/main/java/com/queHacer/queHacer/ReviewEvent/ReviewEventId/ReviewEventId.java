package com.queHacer.queHacer.ReviewEvent.ReviewEventId;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReviewEventId implements Serializable {
    @Column(name = "id_event")
    private Integer idEvent;

    @Column(name = "id_appuser")
    private Integer idAppuser;
}
