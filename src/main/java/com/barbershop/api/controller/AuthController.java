package com.barbershop.api.controller;

import com.barbershop.api.dto.request.LoginRequest;
import com.barbershop.api.dto.request.UsuarioCadastroRequest;
import com.barbershop.api.dto.response.LoginResponse;
import com.barbershop.api.dto.response.UsuarioResponse;
import com.barbershop.api.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Autenticação", description = "Endpoints de registro e login de usuários")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @Operation(summary = "Cadastrar novo usuário", description = "Registra um novo Cliente, Barbeiro ou Admin no sistema")
    public ResponseEntity<UsuarioResponse> register(@Valid @RequestBody UsuarioCadastroRequest request) {
        UsuarioResponse response = authService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    @Operation(summary = "Autenticar usuário", description = "Realiza login e retorna token JWT + dados do usuário")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginResponse response = authService.autenticar(request);
        return ResponseEntity.ok(response);
    }
}
