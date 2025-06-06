package ar.edu.utn.frc.tup.piii.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Value("${app.url}") private String url;
    @Value("${app.dev-name}") private String devName;
    @Value("${app.dev-email}") private String devEmail;

//    @Bean
//    public OpenApi openApi() {
//
//    }
}
