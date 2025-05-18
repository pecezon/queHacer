package com.queHacer.queHacer.CatFact;

import com.queHacer.queHacer.Query;
import com.queHacer.queHacer.User.Model.UserDTO;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@Service
public class CatFactService implements Query<Integer, CatFactDTO> {

    private final String baseURL = "https://catfact.ninja/fact";
    private final RestTemplate restTemplate;
    private final String MAX_LENGTH = "max_length";

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<CatFactDTO> execute (Integer input){
        URI uri = UriComponentsBuilder
                .fromUriString(baseURL)
                .queryParam(MAX_LENGTH, input)
                .build()
                .toUri();

        //headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<CatFactResponse> response = restTemplate
                    .exchange(uri, HttpMethod.GET, entity, CatFactResponse.class);

            CatFactDTO catFactDTO = new CatFactDTO(response.getBody().getFact());
            return ResponseEntity.status(HttpStatus.CREATED).body(catFactDTO);
        } catch (Exception e) {
            throw new RuntimeException("Los gatos han sido papeados");
        }


    }
}
