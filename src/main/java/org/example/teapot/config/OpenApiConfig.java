package org.example.teapot.config;


import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;
@Configuration
@SecurityScheme(
        name = "BasicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)

public class OpenApiConfig {
    @Value("${meli.openapi.dev-url}")
    private String devUrl;


    @Value("${meli.openapi.prod-url}")
    private String prodUrl;


    @Bean
    public OpenAPI teapotOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(this.devUrl);
        devServer.setDescription("Meli API");

        Server prodServer = new Server();
        prodServer.setUrl(this.prodUrl);
        prodServer.setDescription("Meli Server");
        List<Server> servers = new ArrayList<>();
        servers.add(devServer);
        servers.add(prodServer);



        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");


        Info info = new Info()
                .title("Teapot")
                .version("1.0.0")
                .description("This is supposed to be the api description")
                .license(mitLicense);


        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));

    }
}
