package br.com.powerguard.ms_event.dto;

import lombok.Data;

@Data
public class EventDTO {
    private Long userId;
    private String description;
    private String location;
}