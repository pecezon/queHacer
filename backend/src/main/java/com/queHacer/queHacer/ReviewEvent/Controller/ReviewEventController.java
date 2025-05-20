package com.queHacer.queHacer.ReviewEvent.Controller;

import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Service.CreateReviewEventService;
import com.queHacer.queHacer.ReviewEvent.Service.DeleteReviewEventService;
import com.queHacer.queHacer.ReviewEvent.Service.GetAllReviewEventService;
import com.queHacer.queHacer.ReviewEvent.Service.UpdateReviewEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewEventController {
    private final CreateReviewEventService createReviewEventService;
    private final DeleteReviewEventService deleteReviewEventService;
    private final UpdateReviewEventService updateReviewEventService;
    private final GetAllReviewEventService getAllReviewEventService;

    public ReviewEventController(CreateReviewEventService createReviewEventService, DeleteReviewEventService deleteReviewEventService, UpdateReviewEventService updateReviewEventService, GetAllReviewEventService getAllReviewEventService) {
        this.createReviewEventService = createReviewEventService;
        this.deleteReviewEventService = deleteReviewEventService;
        this.updateReviewEventService = updateReviewEventService;
        this.getAllReviewEventService = getAllReviewEventService;
    }

    @PostMapping("/reviewEvent")
    public ResponseEntity<ReviewEventDTO> createReviewEvent(@RequestBody ReviewEventDTO reviewEventDTO){
        return createReviewEventService.execute(reviewEventDTO);
    }

    @GetMapping
    public String getAllReviewEvent(){
        return "optenido";
    }

    @PutMapping String updateReviewEvent(){
        return "actualizado";
    }

    @DeleteMapping String deleteReviewEvent(){
        return "borrado";
    }
}
