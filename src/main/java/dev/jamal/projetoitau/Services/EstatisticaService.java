package dev.jamal.projetoitau.Services;


import dev.jamal.projetoitau.Repositorys.TransacaoRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.Map;


@Service
@Slf4j
public class EstatisticaService {

    private final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Map<String, Object> getEstatistica() {
        transacaoRepository.limparDados();

        DoubleSummaryStatistics stats= transacaoRepository.getValores().stream()
                .mapToDouble(transacao -> transacao.getValor().doubleValue())
                .summaryStatistics();

        if (stats.getCount() == 0){
            log.warn("lista vazia");
            return Map.of(
                    "count", 0,
                    "sum", 0,
                    "avg", 0,
                    "min", 0,
                    "max", 0
            );
        }

        log.info("lista carregada com sucesso");
        return Map.of(
                "count", stats.getCount(),
                "sum", stats.getSum(),
                "avg", stats.getAverage(),
                "min", stats.getMin(),
                "max", stats.getMax()
        );
    }

}
