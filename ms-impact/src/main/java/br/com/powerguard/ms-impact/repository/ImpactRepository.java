package br.com.powerguard.ms_impact.repository;

import br.com.powerguard.ms_impact.model.Impact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImpactRepository extends JpaRepository<Impact, Long> {
    List<Impact> findByEventId(Long eventId);
}