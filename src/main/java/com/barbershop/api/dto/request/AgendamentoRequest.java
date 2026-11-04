package com.barbershop.api.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;

public record AgendamentoRequest(
        @NotNull(message = "O ID do barbeiro é obrigatório")
        Long barbeiroId,

        @NotNull(message = "O ID do serviço é obrigatório")
        Long servicoId,

        @NotNull(message = "A data e hora de início é obrigatória")
        @Future(message = "A data e hora do agendamento deve ser no futuro")
        OffsetDateTime dataHoraInicio,

        String observacao
) {}
