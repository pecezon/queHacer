package com.queHacer.queHacer.AI;

import com.queHacer.queHacer.User.Model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final GetRecomendationByCityService getRecomendationByCityService;

    public AIController(GetRecomendationByCityService getRecomendationByCityService) {
        this.getRecomendationByCityService = getRecomendationByCityService;
    }

    @PostMapping("/get-recommendation")
    public ResponseEntity<String> execute(@RequestBody CityDTO ciudad){
        return getRecomendationByCityService.execute(ciudad);
    }


}
