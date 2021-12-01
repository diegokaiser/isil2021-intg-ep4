package pe.isil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CreateUserApp.class)
public class CreateUserApp {

    public static void main(String[] args) {
        SpringApplication.run(CreateUserApp.class, args);
    }
}
