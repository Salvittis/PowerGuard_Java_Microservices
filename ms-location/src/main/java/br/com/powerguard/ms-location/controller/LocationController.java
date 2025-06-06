package br.com.powerguard.ms_location.controller;

import br.com.powerguard.ms_location.dto.LocationDTO;
import br.com.powerguard.ms_location.model.Location;
import br.com.powerguard.ms_location.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
@Tag(name = "Location Controller", description = "Gerencia as regiões afetadas por falhas de energia")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public void create(@Valid @RequestBody LocationDTO dto) {
        locationService.create(dto);
    }

    @GetMapping("/user/{id}")
    public List<Location> byUser(@PathVariable Long id) {
        return locationService.listByUser(id);
    }

    @GetMapping("/status")
    public List<Location> all() {
        return locationService.listAll();
    }
}