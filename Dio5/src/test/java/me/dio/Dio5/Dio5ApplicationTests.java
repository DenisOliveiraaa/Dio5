package me.dio.Dio5;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;


@SpringBootTest
class Dio5ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servidor de Tarefas")
                        .version("1.0.0")                      
                );
    }
}


