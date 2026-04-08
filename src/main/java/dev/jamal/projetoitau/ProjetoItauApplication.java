package dev.jamal.projetoitau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ProjetoItauApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoItauApplication.class, args);
    }

}
