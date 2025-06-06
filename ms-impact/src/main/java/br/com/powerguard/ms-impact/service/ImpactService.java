package br.com.powerguard.ms_impact.service;

import br.com.powerguard.ms_impact.dto.ImpactDTO;
import br.com.powerguard.ms_impact.model.Impact;
import br.com.powerguard.ms_impact.repository.ImpactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpactService {

    private final ImpactRepository repository;

    public void register(ImpactDTO dto) {
        Impact impact = Impact.builder()
                .eventId(dto.getEventId())
                .description(dto.getDescription())
                .estimatedLoss(dto.getEstimatedLoss())
                .build();
        repository.save(impact);
    }

    public List<Impact> listByEvent(Long eventId) {
        return repository.findByEventId(eventId);
    }
}