package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Place.Exceptions.PlaceCreatorNotFound;
import com.queHacer.queHacer.Place.Model.SummaryPlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.AppUser;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetPlaceByCreatorIdService implements Query<Integer, List<SummaryPlaceDTO>> {

    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    public GetPlaceByCreatorIdService(PlaceRepository placeRepository, UserRepository userRepository) {
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<SummaryPlaceDTO>> execute(Integer input) {
        Optional<AppUser> creator = userRepository.findById(input);
        if(creator.isPresent()){
            List<SummaryPlaceDTO> places = placeRepository.findPlaceByCreatorId(input)
                    .stream()
                    .map(SummaryPlaceDTO::new)
                    .toList();

            return ResponseEntity.ok(places);
        }
        throw new PlaceCreatorNotFound();
    }
}
