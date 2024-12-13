package com.microventas.ventas;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VentasApplicationTests {

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación Spring Boot se cargue correctamente.
    }

    @Test
    void applicationStarts() {
        VentasApplication.main(new String[]{});
        assertThat(true).isTrue(); // Simple validación de que el flujo no lanza excepciones
    }
}
