package ru.gothmog.ws.employes.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@OpenAPIDefinition(info = @Info(title = "EMPLOYS-WS-APP API Service", description = "Модуль Сервис сотрудников", version = "1.0.0"))
@Configuration
public class SpringDocConfiguration {

    private static final String SLASH = "/";
    private static final String SLASH_SERVER_NAME = SLASH + "employs-ws-app";
    private static final String API_GATE_WEY = SLASH + "api-ws-gateway" + SLASH_SERVER_NAME;

    @Value("${app.openapi.local-url}")
    private String localUrl;

    @Value("${app.openapi.develop-url}")
    private String devUrl;

    @Value("${app.openapi.ift-url}")
    private String iftUrl;

    @Value("${app.openapi.prod-url}")
    private String prodUrl;

    @Profile("local")
    @Bean
    public OpenAPI openAPILocal(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, localUrl + SLASH_SERVER_NAME, "Default Server URL");
        addServer(openAPI, devUrl + SLASH_SERVER_NAME, "DEV Server URL");
        addServer(openAPI, iftUrl + SLASH_SERVER_NAME, "IFT Server URL");
        return openAPI;
    }

    @Profile("!local")
    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, localUrl + API_GATE_WEY, "Default Server URL");
        addServer(openAPI, devUrl + API_GATE_WEY, "DEV Server URL");
        addServer(openAPI, iftUrl + API_GATE_WEY, "IFT Server URL");
        return openAPI;
    }

    private void addServer(OpenAPI openAPI, String url, String description) {
        var server = new io.swagger.v3.oas.models.servers.Server();
        server.setUrl(url);
        server.setDescription(description);
        openAPI.addServersItem(server);
    }
}
