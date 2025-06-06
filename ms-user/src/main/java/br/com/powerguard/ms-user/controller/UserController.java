package br.com.powerguard.ms_user.controller;

import br.com.powerguard.ms_user.dto.*;
import br.com.powerguard.ms_user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "Gerencia autenticação e perfil do usuário")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto);
    }

    @PostMapping("/login")
    public UserResponseDTO login(@Valid @RequestBody UserLoginDTO dto) {
        return userService.login(dto);
    }

    @GetMapping("/me")
    public UserResponseDTO me() {
        return userService.getProfile();
    }
}