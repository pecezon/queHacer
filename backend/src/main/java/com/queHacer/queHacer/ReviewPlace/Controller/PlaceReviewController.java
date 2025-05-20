package com.queHacer.queHacer.ReviewPlace.Controller;

import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.ReviewEvent.Model.ReviewEventDTO;
import com.queHacer.queHacer.ReviewPlace.Model.CreatePlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Model.UpdatePlaceReviewCommand;
import com.queHacer.queHacer.ReviewPlace.Model.UpdatePlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.PlaceReviewId.PlaceReviewId;
import com.queHacer.queHacer.ReviewPlace.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place-review")
public class PlaceReviewController {

    private final CreatePlaceReviewService createPlaceReviewService;
    private final UpdatePlaceReviewService updatePlaceReviewService;
    private final DeletePlaceReviewService deletePlaceReviewService;
    private final GetPlaceReviewByIdService getPlaceReviewByIdService;
    private final GetAllReviewsForPlace getAllReviewsForPlace;

    public PlaceReviewController(CreatePlaceReviewService createPlaceReviewService, UpdatePlaceReviewService updatePlaceReviewService, DeletePlaceReviewService deletePlaceReviewService, GetPlaceReviewByIdService getPlaceReviewByIdService, GetAllReviewsForPlace getAllReviewsForPlace) {
        this.createPlaceReviewService = createPlaceReviewService;
        this.updatePlaceReviewService = updatePlaceReviewService;
        this.deletePlaceReviewService = deletePlaceReviewService;
        this.getPlaceReviewByIdService = getPlaceReviewByIdService;
        this.getAllReviewsForPlace = getAllReviewsForPlace;
    }
    @PostMapping()
    public ResponseEntity<PlaceReviewDTO> createReviewEvent(@RequestBody CreatePlaceReviewDTO reviewEventDTO){
        return createPlaceReviewService.execute(reviewEventDTO);
    }


    @PutMapping("/{idPlace}/{idAppuser}")
    public ResponseEntity<PlaceReviewDTO> updatePlaceReview(@PathVariable Integer idPlace,
                                                            @PathVariable Integer idAppuser, @RequestBody UpdatePlaceReviewCommand input){
        return updatePlaceReviewService.execute(new UpdatePlaceReviewDTO(new PlaceReviewId(idPlace,idAppuser),input));
    }

    @DeleteMapping("/{idPlace}/{idAppuser}")
    public ResponseEntity<Void> deleteReviewEvent(@PathVariable Integer idPlace,
                                                  @PathVariable Integer idAppuser){
        return deletePlaceReviewService.execute(new PlaceReviewId(idPlace,idAppuser));
    }

    @GetMapping("/{idPlace}/{idAppuser}")
    public ResponseEntity<PlaceReviewDTO> getPlaceReviewById(
            @PathVariable Long idPlace,
            @PathVariable Integer idAppuser) {

        PlaceReviewId id = new PlaceReviewId();
        id.setIdPlace(idPlace);
        id.setIdAppuser(idAppuser);

        return getPlaceReviewByIdService.execute(id);
    }

    @GetMapping("/{idPlace}")
    public ResponseEntity<List<PlaceReviewDTO>> findAllReviewsOfAPlace(@PathVariable Long id){
        return getAllReviewsForPlace.execute(id);
    }


}
