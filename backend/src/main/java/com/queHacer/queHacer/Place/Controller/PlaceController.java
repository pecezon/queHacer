package com.queHacer.queHacer.Place.Controller;

import com.queHacer.queHacer.Place.Exceptions.InvalidPlaceSearchException;
import com.queHacer.queHacer.Place.Exceptions.PlaceCreatorNotFound;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotValidException;
import com.queHacer.queHacer.Place.Model.*;
import com.queHacer.queHacer.Place.Service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    private final UpdatePlaceService updatePlaceService;
    private final CreatePlaceService createPlaceService;
    private final DeletePlaceService deletePlaceService;
    private final GetPlaceByIdService getPlaceByIdService;
    private final SearchPlaceService searchPlaceService;
    private final GetPlaceByCreatorIdService getPlaceByCreatorIdService;
    private final SearchPlacesByCityAndCountryService searchPlacesByCityAndCountryService;
    private final GetPlacesByPriceRangeService getPlacesByPriceRangeService;
    private final GetFullPlaceService getFullPlaceService;
    private final GetAllPlacesService getAllPlacesService;


    public PlaceController(UpdatePlaceService updatePlaceService, CreatePlaceService createPlaceService, DeletePlaceService deletePlaceService, GetPlaceByIdService getPlaceByIdService, SearchPlaceService searchPlaceService, GetPlaceByCreatorIdService getPlaceByCreatorIdService, SearchPlacesByCityAndCountryService searchPlacesByCityAndCountryService, GetPlacesByPriceRangeService getPlacesByPriceRangeService, GetFullPlaceService getFullPlaceService, GetAllPlacesService getAllPlacesService) {
        this.updatePlaceService = updatePlaceService;
        this.createPlaceService = createPlaceService;
        this.deletePlaceService = deletePlaceService;
        this.getPlaceByIdService = getPlaceByIdService;
        this.searchPlaceService = searchPlaceService;
        this.getPlaceByCreatorIdService = getPlaceByCreatorIdService;
        this.searchPlacesByCityAndCountryService = searchPlacesByCityAndCountryService;
        this.getPlacesByPriceRangeService = getPlacesByPriceRangeService;
        this.getFullPlaceService = getFullPlaceService;
        this.getAllPlacesService = getAllPlacesService;
    }

    @GetMapping("search/all")
    public ResponseEntity<List<PlaceDTO>> getAllPlaces() {
        return getAllPlacesService.execute(null);
    }

    //@PreAuthorize("hasRole('ADMIN') or hasRole('EVENT_CREATOR')")
    @PostMapping
    public ResponseEntity<PlaceDTO> createPlace(@RequestBody PlaceDTO placedto){
       return createPlaceService.execute(placedto);
    }

    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/{id}")
    public ResponseEntity<PlaceDTO> getPlaceById(@PathVariable Long id){
        return getPlaceByIdService.execute(id);
    }

    @GetMapping("/search/by-price-range")
    public ResponseEntity<List<SummaryPlaceDTO>> searchPlacesByPriceRange(@RequestParam (required = false) Float minPrice, @RequestParam(required = false) Float maxPrice){return getPlacesByPriceRangeService.execute(new SearchPlacesByPriceRangeCommand(minPrice, maxPrice));}

    @GetMapping("/search/by-name")
    public ResponseEntity<List<SummaryPlaceDTO>> searchPlaceByNameOrDescriptionContaining(@RequestParam String name){
        return searchPlaceService.execute(name);
    }
    @GetMapping("/search/by-country-city")
    public ResponseEntity<List<SummaryPlaceDTO>> searchPlacesByCountryAndCity(@RequestParam String city, @RequestParam String country){
        return searchPlacesByCityAndCountryService.execute(new SearchPlaceByCityAndCountryCommand(city,country));
    }

    //@PreAuthorize("hasRole('ADMIN') or #creatorId == authentication.principal.id")
    @GetMapping("/creator/{creatorId}")
    public ResponseEntity<List<SummaryPlaceDTO>> getPlaceByCreatorId(@PathVariable Integer creatorId){
        return getPlaceByCreatorIdService.execute(creatorId);
    }

    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @GetMapping("/full-view/{id}")
    public ResponseEntity<DisplayFullPlaceInfoDTO> getFullPlaceViewById(@PathVariable Long id){
        return getFullPlaceService.execute(id);
    }

    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
    @PutMapping("/{id}")
    public ResponseEntity<PlaceDTO> updatePlace(@PathVariable Long id, @RequestBody UpdatePlaceDTO updatedPlace){
        return updatePlaceService.execute(new UpdatePlaceCommand(id, updatedPlace));
    }

    //@PreAuthorize("hasRole('ADMIN') or #id == authentication.principal.id")
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

    @ExceptionHandler(InvalidPlaceSearchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public PlaceErrorResponse handleInvalidPlaceSearch(PlaceCreatorNotFound exception){
        return new PlaceErrorResponse(exception.getMessage());
    }

}
