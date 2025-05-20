package com.queHacer.queHacer.ReviewEvent.Controller;

import com.queHacer.queHacer.Event.Exceptions.EventNotFoundException;
import com.queHacer.queHacer.Event.Exceptions.EventNotValidException;
import com.queHacer.queHacer.Event.Model.EventErrorResponse;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotFoundException;
import com.queHacer.queHacer.ReviewEvent.Exceptions.ReviewEventNotValidException;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventErrorResponse;
import com.queHacer.queHacer.ReviewEvent.Model.UpdateReviewEventCommand;
import com.queHacer.queHacer.ReviewEvent.Model.UpdateReviewEventDTO;
import com.queHacer.queHacer.ReviewEvent.ReviewEventId.ReviewEventId;
import com.queHacer.queHacer.ReviewEvent.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewEventController {
    private final CreateReviewEventService createReviewEventService;
    private final DeleteReviewEventService deleteReviewEventService;
    private final UpdateReviewEventService updateReviewEventService;
    private final GetAllReviewEventService getAllReviewEventService;
    private final GetAllReviewsOfASingleEventService getAllReviewsOfASingleEventService;

    public ReviewEventController(CreateReviewEventService createReviewEventService, DeleteReviewEventService deleteReviewEventService, UpdateReviewEventService updateReviewEventService, GetAllReviewEventService getAllReviewEventService, GetAllReviewsOfASingleEventService getAllReviewsOfASingleEventService) {
        this.createReviewEventService = createReviewEventService;
        this.deleteReviewEventService = deleteReviewEventService;
        this.updateReviewEventService = updateReviewEventService;
        this.getAllReviewEventService = getAllReviewEventService;
        this.getAllReviewsOfASingleEventService = getAllReviewsOfASingleEventService;
    }

    @PostMapping("/reviewEvent")
    public ResponseEntity<ReviewEventDTO> createReviewEvent(@RequestBody ReviewEventDTO reviewEventDTO){
        return createReviewEventService.execute(reviewEventDTO);
    }

    @GetMapping("/reviewEvents")
    public ResponseEntity<List<ReviewEventDTO>> getAllReviewEvent(){
        return getAllReviewEventService.execute(null);
    }

    @PutMapping("/reviewEvent/{idEvent}/{idAppuser}")
    public ResponseEntity<ReviewEventDTO> updateReviewEvent(@PathVariable Integer idEvent,
                                                            @PathVariable Integer idAppuser, @RequestBody UpdateReviewEventDTO updateReviewEventDTO){
        return updateReviewEventService.execute(new UpdateReviewEventCommand(new ReviewEventId(idEvent,idAppuser),updateReviewEventDTO));
    }

    @DeleteMapping("/reviewEvent/{idEvent}/{idAppuser}")
    public ResponseEntity<Void> deleteReviewEvent(@PathVariable Integer idEvent,
                                                  @PathVariable Integer idAppuser){
        return deleteReviewEventService.execute(new ReviewEventId(idEvent,idAppuser));
    }

    @GetMapping("/reviewEvent/{idEvent}")
    public ResponseEntity<List<ReviewEventDTO>> findAllReviewsOfAnEvent(@PathVariable Integer id){
        return getAllReviewsOfASingleEventService.execute(id);
    }


    @ExceptionHandler(ReviewEventNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ReviewEventErrorResponse handleReviewEventNotFoundException(ReviewEventNotFoundException e){
        return new ReviewEventErrorResponse(e.getMessage());
    }

    @ExceptionHandler(EventNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ReviewEventErrorResponse handleReviewEventNotValidException(ReviewEventNotValidException e){
        return new ReviewEventErrorResponse(e.getMessage());
    }
}
