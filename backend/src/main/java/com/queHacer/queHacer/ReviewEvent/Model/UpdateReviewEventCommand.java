package com.queHacer.queHacer.ReviewEvent.Model;

import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import lombok.Getter;

@Getter
public class UpdateReviewEventCommand {

    private ReviewEventId id;
     private UpdateReviewEventDTO updateReviewEventDTO;

    public UpdateReviewEventCommand(ReviewEventId id, UpdateReviewEventDTO updateReviewEventDTO) {
        this.id = id;
        this.updateReviewEventDTO = updateReviewEventDTO;
    }
}
