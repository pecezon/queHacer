package com.queHacer.queHacer.ReviewPlace.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Exceptions.UserNotFoundException;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.ReviewPlace.Model.CreatePlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReview;
import com.queHacer.queHacer.ReviewPlace.Model.PlaceReviewDTO;
import com.queHacer.queHacer.ReviewPlace.Repository.PlaceReviewRepository;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatePlaceReviewService implements Command<CreatePlaceReviewDTO, PlaceReviewDTO> {

    private final PlaceReviewRepository placeReviewRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;
    public CreatePlaceReviewService(PlaceReviewRepository placeReviewRepository, PlaceRepository placeRepository, UserRepository userRepository) {
        this.placeReviewRepository = placeReviewRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<PlaceReviewDTO> execute(CreatePlaceReviewDTO input) {

        Optional<Place> tempPlace = placeRepository.findById(input.getIdPlace());

        if(tempPlace.isEmpty()){
            throw new PlaceNotFoundException();
        }

        Optional<AppUser> tempUser = userRepository.findById(input.getIdAppuser());
        if(tempUser.isEmpty()){
            throw new UserNotFoundException();
        }

        Place place = tempPlace.get();
        place.setReviewSum(place.getReviewSum() + input.getRating());
        place.setReviewCount(place.getReviewCount() + 1);
        placeRepository.save(place);

        AppUser user = tempUser.get();

        PlaceReview review = new PlaceReview();

        review.setPlace(place);
        review.setAppUser(user);
        review.setDescription(input.getDescription());
        review.setRating(input.getRating());

        PlaceReview saved = placeReviewRepository.save(review);

        return ResponseEntity.status(HttpStatus.CREATED).body(new PlaceReviewDTO(saved));
    }
}
