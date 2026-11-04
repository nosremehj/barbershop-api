package com.barbershop.api.dto.response;

import java.math.BigDecimal;

public record ServicoResponse(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Integer duracaoMinutos,
        Boolean ativo
) {}
