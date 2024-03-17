package ru.gothmog.ws.employes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@OpenAPIDefinition(info = @Info(title = "EMPLOYS-WS-APP API Service", description = "Модуль Сервис сотрудников", version = "1.0.0"))
@Configuration
public class SpringDocConfiguration {

    @Profile("local")
    @Bean
    public OpenAPI openAPILocal(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, "/", "Default Server URL");
        addServer(openAPI, "https://ingress.gothmog.ru/employs-ws-app", "DEV Server URL");
        addServer(openAPI, "https://ingress.it-gothmog.ru/employs-ws-app", "IFT Server URL");
        return openAPI;
    }

    @Profile("!local")
    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, "/api-ws-gateway/employs-ws-app", "Default Server URL");
        addServer(openAPI, "https://ingress.gothmog.ru/apo-ws-gateway/employs-ws-app", "DEV Server URL");
        addServer(openAPI, "https://ingress.it-gothmog.ru/api-ws-gateway/employs-ws-app", "IFT Server URL");
        return openAPI;
    }

    private void addServer(OpenAPI openAPI, String url, String description) {
        var server = new io.swagger.v3.oas.models.servers.Server();
        server.setUrl(url);
        server.setDescription(description);
        openAPI.addServersItem(server);
    }
}
