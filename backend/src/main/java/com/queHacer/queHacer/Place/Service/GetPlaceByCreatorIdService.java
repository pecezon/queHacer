package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Exceptions.ErrorMessages;
import com.queHacer.queHacer.Place.Exceptions.PlaceCreatorNotFound;
import com.queHacer.queHacer.Place.Exceptions.PlaceErrorMessages;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPlaceByCreatorIdService implements Query<Integer, List<PlaceDTO>> {

    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    public GetPlaceByCreatorIdService(PlaceRepository placeRepository, UserRepository userRepository) {
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<PlaceDTO>> execute(Integer input) {
        Optional<User> creator = userRepository.findById(input);
        if(creator.isPresent()){
            List<PlaceDTO> places = placeRepository.findPlaceByCreatorId(input)
                    .stream()
                    .map(PlaceDTO::new)
                    .toList();

            return ResponseEntity.ok(places);
        }
        throw new PlaceCreatorNotFound();
    }
}
