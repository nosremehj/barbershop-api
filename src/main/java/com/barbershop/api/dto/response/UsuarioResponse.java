package com.barbershop.api.dto.response;

import com.barbershop.api.domain.enums.Role;
import java.time.OffsetDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        Role role,
        Boolean ativo,
        OffsetDateTime criadoEm
) {}
