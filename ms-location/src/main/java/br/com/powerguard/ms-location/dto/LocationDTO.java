package br.com.powerguard.ms_location.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Long userId;
    private String region;
    private String status;
}