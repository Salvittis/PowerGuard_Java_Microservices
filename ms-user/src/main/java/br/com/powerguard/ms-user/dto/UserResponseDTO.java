package br.com.powerguard.ms_user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
    private String token;
}