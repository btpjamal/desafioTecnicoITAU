package dev.jamal.projetoitau.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "estatistica")
public record EstatisticaProperties(Integer segunfos) {

}
