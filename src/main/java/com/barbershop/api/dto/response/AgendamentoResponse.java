package com.barbershop.api.dto.response;

import com.barbershop.api.domain.enums.StatusAgendamento;
import java.time.OffsetDateTime;

public record AgendamentoResponse(
        Long id,
        Long clienteId,
        String clienteNome,
        Long barbeiroId,
        String barbeiroNome,
        Long servicoId,
        String servicoNome,
        OffsetDateTime dataHoraInicio,
        OffsetDateTime dataHoraFim,
        StatusAgendamento status,
        String observacao,
        OffsetDateTime criadoEm
) {}
