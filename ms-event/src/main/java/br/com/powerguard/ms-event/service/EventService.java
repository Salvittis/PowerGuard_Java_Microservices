package br.com.powerguard.ms_event.service;

import br.com.powerguard.ms_event.dto.EventDTO;
import br.com.powerguard.ms_event.model.Event;
import br.com.powerguard.ms_event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    public void report(EventDTO dto) {
        Event event = Event.builder()
                .userId(dto.getUserId())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .status("PENDING")
                .timestamp(LocalDateTime.now())
                .build();
        repository.save(event);
    }

    public List<Event> listByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Event> listAll() {
        return repository.findAll();
    }

    public void updateStatus(Long id, String status) {
        Event event = repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
        event.setStatus(status);
        repository.save(event);
    }
}