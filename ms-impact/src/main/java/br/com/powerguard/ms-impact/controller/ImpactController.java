package br.com.powerguard.ms_impact.controller;

import br.com.powerguard.ms_impact.dto.ImpactDTO;
import br.com.powerguard.ms_impact.model.Impact;
import br.com.powerguard.ms_impact.service.ImpactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impact")
@RequiredArgsConstructor
@Tag(name = "Impact Controller", description = "Gerencia os impactos causados pelos eventos")
public class ImpactController {

    private final ImpactService impactService;

    @PostMapping
    public void register(@Valid @RequestBody ImpactDTO dto) {
        impactService.register(dto);
    }

    @GetMapping("/event/{id}")
    public List<Impact> byEvent(@PathVariable Long id) {
        return impactService.listByEvent(id);
    }
}