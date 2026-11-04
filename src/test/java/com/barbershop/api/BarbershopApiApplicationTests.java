package com.barbershop.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class BarbershopApiApplicationTests {

    @Test
    void contextLoads() {
        // Valida se todo o contexto do Spring Boot, injeção de dependências,
        // entidades JPA e configurações sobem com sucesso.
    }
}
