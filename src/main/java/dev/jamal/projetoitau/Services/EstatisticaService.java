package dev.jamal.projetoitau.Services;


import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import dev.jamal.projetoitau.Repositorys.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.Map;


@Service
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

        if (transacaoRepository.getValores() == null){
            return Map.of(
                    "count", 0,
                    "sum", 0,
                    "avg", 0,
                    "min", 0,
                    "max", 0
            );
        }

        return Map.of(
                "count", stats.getCount(),
                "sum", stats.getSum(),
                "avg", stats.getAverage(),
                "min", stats.getMin(),
                "max", stats.getMax()
        );
    }

}
