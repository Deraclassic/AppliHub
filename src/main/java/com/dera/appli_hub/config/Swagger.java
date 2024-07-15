package com.dera.appli_hub.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "AppliHub",
                description = "Job Application System",
                version = "1.0",
                contact = @Contact(
                        name = "Chidera Uzoigwe",
                        email = "chiderauzoigwe2@gmail.com",
                        url = "https://github.com/Deraclassic"
                ),
                license = @License(
                        name = "AppliHub Application",
                        url = "https://github.com/Deraclassic/job_board"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Job Application System",
                url = "https://github.com/Deraclassic/job_board"
        ),
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class Swagger {
}
