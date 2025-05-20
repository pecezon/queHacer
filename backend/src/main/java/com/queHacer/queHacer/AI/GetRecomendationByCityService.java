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
                Imagina que soy un turista en busca de lugares y eventos para mi visita a la ciudad de %s, que recomendaciones de lugares iconicos y locales me darias, formatea tu respuesta con un breve parrafo platicado sin signos de puntuacion diferentes a comas y puntos
        """.formatted(ciudad.getCiudad());
        String response = aiService.chat(prompt);

        if (response == null) {
            throw new RuntimeException();
        }
        return ResponseEntity.ok(response);
    }
}
