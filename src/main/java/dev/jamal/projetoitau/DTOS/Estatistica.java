package dev.jamal.projetoitau.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Estatistica {

    private final Long count;
    private final Double sum;
    private final Double avg;
    private final Double min;
    private final Double man;
}
