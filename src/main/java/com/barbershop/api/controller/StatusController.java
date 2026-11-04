package com.barbershop.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/status")
@Tag(name = "Status", description = "Verificação de integridade da API")
public class StatusController {

    @GetMapping
    @Operation(summary = "Health check da API", description = "Retorna o status atual do serviço")
    public ResponseEntity<Map<String, Object>> getStatus() {
        return ResponseEntity.ok(Map.of(
                "status", "UP",
                "servico", "barbershop-api",
                "versao", "1.0.0",
                "timestamp", OffsetDateTime.now().toString()
        ));
    }
}
