package br.com.powerguard.ms_impact.dto;

import lombok.Data;

@Data
public class ImpactDTO {
    private Long eventId;
    private String description;
    private Double estimatedLoss;
}