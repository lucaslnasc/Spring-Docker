package br.com.lucaslnasc.spring_docker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
class SpringDockerApplicationTests {

    @Test
    void contextLoads() {
        // Teste vazio apenas para verificar se o contexto carrega
    }

}
