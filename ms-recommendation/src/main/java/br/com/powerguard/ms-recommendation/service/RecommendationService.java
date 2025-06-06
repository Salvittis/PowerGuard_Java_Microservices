package br.com.powerguard.ms_recommendation.service;

import br.com.powerguard.ms_recommendation.dto.RecommendationDTO;
import br.com.powerguard.ms_recommendation.model.Recommendation;
import br.com.powerguard.ms_recommendation.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository repository;

    public void create(RecommendationDTO dto) {
        Recommendation rec = Recommendation.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        repository.save(rec);
    }

    public List<Recommendation> listAll() {
        return repository.findAll();
    }
}