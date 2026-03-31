package dev.jamal.projetoitau.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class TransacaoDTO {

    private BigDecimal valor;
    private OffsetDateTime dataHora;


}
