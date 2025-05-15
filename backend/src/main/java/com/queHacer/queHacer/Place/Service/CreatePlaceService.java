package com.queHacer.queHacer.Place.Service;

import com.queHacer.queHacer.Command;
import com.queHacer.queHacer.Place.Model.Place;
import com.queHacer.queHacer.Place.Model.PlaceDTO;
import com.queHacer.queHacer.Place.Repository.PlaceRepository;
import com.queHacer.queHacer.Place.Validators.PlaceValidator;
import com.queHacer.queHacer.User.Model.User;
import com.queHacer.queHacer.User.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreatePlaceService implements Command<PlaceDTO, PlaceDTO> {

    private final PlaceRepository repository;
    private final UserRepository userRepository;

    public CreatePlaceService(PlaceRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<PlaceDTO> execute(PlaceDTO dto) {
        // Buscar el creador
        User creator = userRepository.findById(dto.getCreatorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Armar el place
        Place place = new Place();
        place.setName(dto.getName());
        place.setDescription(dto.getDescription());
        //place.setPriceRange(dto.getPriceRange());
        place.setMinPrice(dto.getMinPrice());
        place.setMaxPrice(dto.getMaxPrice());
        place.setInstagram(dto.getInstagram());
        place.setFacebook(dto.getFacebook());
        place.setWhatsapp(dto.getWhatsapp());
        place.setTwitter(dto.getTwitter());
        place.setStreetNumber(dto.getStreetNumber());
        place.setStreet(dto.getStreet());
        place.setCp(dto.getCp());
        place.setCounty(dto.getCounty());
        place.setCity(dto.getCity());
        place.setCountry(dto.getCountry());
        place.setMenu(dto.getMenu());
        place.setPhoneNumber(dto.getPhoneNumber());
        place.setReviewCount(dto.getReviewCount() != null ? dto.getReviewCount() : 0L);
        place.setReviewSum(dto.getReviewSum() != null ? dto.getReviewSum() : 0.0);
        place.setCreator(creator);

        // Validación
        PlaceValidator.execute(place);

        // Guardar y devolver DTO
        Place savedPlace = repository.save(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PlaceDTO(savedPlace));
    }
}
