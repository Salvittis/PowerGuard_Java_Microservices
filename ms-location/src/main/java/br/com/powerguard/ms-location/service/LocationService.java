package br.com.powerguard.ms_location.service;

import br.com.powerguard.ms_location.dto.LocationDTO;
import br.com.powerguard.ms_location.model.Location;
import br.com.powerguard.ms_location.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    public void create(LocationDTO dto) {
        Location location = Location.builder()
                .userId(dto.getUserId())
                .region(dto.getRegion())
                .status(dto.getStatus())
                .build();
        repository.save(location);
    }

    public List<Location> listByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Location> listAll() {
        return repository.findAll();
    }
}