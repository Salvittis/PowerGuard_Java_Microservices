package br.com.powerguard.ms_event.controller;

import br.com.powerguard.ms_event.dto.EventDTO;
import br.com.powerguard.ms_event.model.Event;
import br.com.powerguard.ms_event.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@Tag(name = "Event Controller", description = "Gerencia os eventos de falta de energia")
public class EventController {

    private final EventService eventService;

    @PostMapping("/report")
    public void report(@Valid @RequestBody EventDTO dto) {
        eventService.report(dto);
    }

    @GetMapping("/user/{id}")
    public List<Event> byUser(@PathVariable Long id) {
        return eventService.listByUser(id);
    }

    @GetMapping("/all")
    public List<Event> all() {
        return eventService.listAll();
    }

    @PutMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        eventService.updateStatus(id, status);
    }
}