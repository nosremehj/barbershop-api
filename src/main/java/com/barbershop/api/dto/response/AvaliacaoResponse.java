package com.barbershop.api.dto.response;

import java.time.OffsetDateTime;

public record AvaliacaoResponse(
        Long id,
        Long agendamentoId,
        String clienteNome,
        String barbeiroNome,
        Integer nota,
        String comentario,
        OffsetDateTime criadoEm
) {}
