package com.queHacer.queHacer.ReviewEvent.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReviewEventDTO {
    private Integer id;
    private Integer idEvent;
    private Integer idAppuser;
    private String description;
    private Double rating;

    public ReviewEventDTO(ReviewEvent reviewEvent){
        this.id = reviewEvent.getId();
        this.description = reviewEvent.getDescription();
        this.rating = reviewEvent.getRating();
        this.idEvent = reviewEvent.getEvent() != null ? reviewEvent.getEvent().getId() : null;
        this.idAppuser = reviewEvent.getAppUser() != null ? reviewEvent.getAppUser().getId() : null;
    }
}
