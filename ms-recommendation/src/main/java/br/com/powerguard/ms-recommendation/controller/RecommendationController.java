package br.com.powerguard.ms_recommendation.controller;

import br.com.powerguard.ms_recommendation.dto.RecommendationDTO;
import br.com.powerguard.ms_recommendation.model.Recommendation;
import br.com.powerguard.ms_recommendation.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@RequiredArgsConstructor
@Tag(name = "Recommendation Controller", description = "Fornece recomendações e boas práticas à população")
public class RecommendationController {

    private final RecommendationService service;

    @PostMapping
    public void create(@Valid @RequestBody RecommendationDTO dto) {
        service.create(dto);
    }

    @GetMapping
    public List<Recommendation> listAll() {
        return service.listAll();
    }
}