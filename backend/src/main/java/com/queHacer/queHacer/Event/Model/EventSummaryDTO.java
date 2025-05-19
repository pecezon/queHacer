package com.queHacer.queHacer.Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventSummaryDTO {

    private Integer id;
    private String name;
    private String description;
    private Double sumReviews;
    private Long cantReviews;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public EventSummaryDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.sumReviews = event.getSumReviews();
        this.cantReviews = event.getCantReviews();
        this.startDate = event.getStartDate();
        this.endDate = event.getEndDate();
    }
}
