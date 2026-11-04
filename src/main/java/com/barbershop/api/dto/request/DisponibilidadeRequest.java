package com.barbershop.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;

public record DisponibilidadeRequest(
        @NotNull(message = "O dia da semana é obrigatório")
        @Min(value = 1, message = "Dia da semana deve ser entre 1 (Segunda) e 7 (Domingo)")
        @Max(value = 7, message = "Dia da semana deve ser entre 1 (Segunda) e 7 (Domingo)")
        Integer diaSemana,

        @NotNull(message = "Hora de início é obrigatória")
        LocalTime horaInicio,

        @NotNull(message = "Hora de fim é obrigatória")
        LocalTime horaFim,

        LocalTime horaInicioAlmoco,
        LocalTime horaFimAlmoco
) {}
