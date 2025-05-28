package com.queHacer.queHacer.AI;

import com.queHacer.queHacer.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetRecomendationByCityService implements Query<CityDTO, String> {

    private final AIService aiService;

    public GetRecomendationByCityService(AIService aiService) {
        this.aiService = aiService;
    }

    @Override
    public ResponseEntity<String> execute(CityDTO ciudad) {
        String prompt ="""
                Eres parte de una startup tecnologica llamada que hacer la funcion de este prompt es recibir el nombre de la ciudad %s
                y dar un parrafo breve de lugares turisticos mas locales que comerciales, busca dar los sitios y eventos mas autenticos y amados
                por los mismos habitantes de la ciudad.
        """.formatted(ciudad.getCiudad());
        String response = aiService.chat(prompt);

        if (response == null) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok(response);
    }
}
