package com.github.wiriswernek.capsula_do_tempo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Capsula do Tempo API",
                version = "1.0.0",
                description = "API de gerenciamento de cápsulas do tempo para armazenar mensagens e fotos.",
                termsOfService = "wiriswernek",
                contact = @Contact(
                        name = "Wiris Wernek",
                        email = "wiriswernek@gmail.com"
                ),
                license = @License(
                        name = "licence",
                        url = "license"
                )
        )
)
public class SwaggerConfig {
}
