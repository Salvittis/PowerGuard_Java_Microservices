package br.com.powerguard.ms_recommendation.repository;

import br.com.powerguard.ms_recommendation.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}