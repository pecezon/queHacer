package com.queHacer.queHacer.Place.Controller;

import com.queHacer.queHacer.Place.Exceptions.PlaceCreatorNotFound;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Model.PlaceErrorResponse;
import com.queHacer.queHacer.Place.Model.UpdatePlaceCommand;
import com.queHacer.queHacer.Place.Service.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/place")
public class PlaceController {

    private final UpdatePlaceService updatePlaceService;
    private final CreatePlaceService createPlaceService;
    private final DeletePlaceService deletePlaceService;
    private final GetPlaceByIdService getPlaceByIdService;
    private final SearchPlaceService searchPlaceService;
    private final GetPlaceByCreatorIdService getPlaceByCreatorIdService;


    public PlaceController(UpdatePlaceService updatePlaceService, CreatePlaceService createPlaceService, DeletePlaceService deletePlaceService, GetPlaceByIdService getPlaceByIdService, SearchPlaceService searchPlaceService, GetPlaceByCreatorIdService getPlaceByCreatorIdService) {
        this.updatePlaceService = updatePlaceService;
        this.createPlaceService = createPlaceService;
        this.deletePlaceService = deletePlaceService;
        this.getPlaceByIdService = getPlaceByIdService;
        this.searchPlaceService = searchPlaceService;
        this.getPlaceByCreatorIdService = getPlaceByCreatorIdService;
    }

    @PostMapping
    public ResponseEntity<PlaceDTO> createPlace(@RequestBody Place place){
       return createPlaceService.execute(place);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPlaceById(@PathVariable Long id){
        return getPlaceByIdService.execute(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlaceDTO>> SearchPlaceByNameOrDescriptionContaining(@RequestParam String name){
        return searchPlaceService.execute(name);
    }


    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<List<PlaceDTO>> getPlaceByCreatorId(@PathVariable Integer creatorId){
        return getPlaceByCreatorIdService.execute(creatorId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id, @RequestBody Place updatedPlace){
        return updatePlaceService.execute(new UpdatePlaceCommand(id, updatedPlace));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long id){
        return deletePlaceService.execute(id);
    }

    @ExceptionHandler(PlaceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public PlaceErrorResponse handlePlaceNotFoundException(PlaceNotFoundException exception){
        return new PlaceErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(PlaceNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public PlaceErrorResponse handlePlaceNotValidException(PlaceNotValidException exception){
        return new PlaceErrorResponse(exception.getMessage());
    }

    @ExceptionHandler(PlaceCreatorNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public PlaceErrorResponse handlePlaceCreatorNotFound(PlaceCreatorNotFound exception){
        return new PlaceErrorResponse(exception.getMessage());
    }

}
