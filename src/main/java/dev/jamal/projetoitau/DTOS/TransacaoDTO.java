package dev.jamal.projetoitau.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransacaoDTO {

    private BigDecimal valor;
    private OffsetDateTime dataHora;


}
