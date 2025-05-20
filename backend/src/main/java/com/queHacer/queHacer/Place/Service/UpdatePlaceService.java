package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Exceptions.PlaceNotFoundException;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Model.UpdatePlaceCommand;
import com.queHacer.queHacer.Place.Model.UpdatePlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlaceValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePlaceService implements Command<UpdatePlaceCommand, PlaceDTO> {
    private final PlaceRepository placeRepository;

    public UpdatePlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public ResponseEntity<PlaceDTO> execute(UpdatePlaceCommand input) {
        Optional<Place> optional = placeRepository.findById(input.getId());
        if (optional.isEmpty()) throw new PlaceNotFoundException();

        Place place = optional.get();
        UpdatePlaceDTO dto = input.getUpdatePlaceDTO();

        if (dto.getName() != null) place.setName(dto.getName());
        if (dto.getDescription() != null) place.setDescription(dto.getDescription());
        if (dto.getMinPrice() != null) place.setMinPrice(dto.getMinPrice());
        if(dto.getMaxPrice() != null) place.setMaxPrice(dto.getMaxPrice());
        if (dto.getInstagram() != null) place.setInstagram(dto.getInstagram());
        if (dto.getFacebook() != null) place.setFacebook(dto.getFacebook());
        if (dto.getWhatsapp() != null) place.setWhatsapp(dto.getWhatsapp());
        if (dto.getTwitter() != null) place.setTwitter(dto.getTwitter());
        if (dto.getStreetNumber() != null) place.setStreetNumber(dto.getStreetNumber());
        if (dto.getStreet() != null) place.setStreet(dto.getStreet());
        if (dto.getCp() != null) place.setCp(dto.getCp());
        if (dto.getCounty() != null) place.setCounty(dto.getCounty());
        if (dto.getCity() != null) place.setCity(dto.getCity());
        if (dto.getCountry() != null) place.setCountry(dto.getCountry());
        if (dto.getMenu() != null) place.setMenu(dto.getMenu());
        if (dto.getPhoneNumber() != null) place.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getReviewCount() != null) place.setReviewCount(dto.getReviewCount());
        if (dto.getReviewSum() != null) place.setReviewSum(dto.getReviewSum());
        if(dto.getMainImage() != null) place.setMainImage(dto.getMainImage());

        PlaceValidator.execute(place);
        Place updated = placeRepository.save(place);
        return ResponseEntity.ok(new PlaceDTO(updated));
    }
}
