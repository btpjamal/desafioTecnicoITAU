package dev.jamal.projetoitau.Services;


import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import dev.jamal.projetoitau.Repositorys.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class EstatisticaService {

    private final TransacaoRepository transacaoRepository;

    public EstatisticaService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public Map<String, Object> getEstatistica() {
        return Map.of(
                "count" , transacaoRepository.getValores().size(),

                "sum" , transacaoRepository.getValores().stream()
                        .mapToDouble(transacao -> transacao.getValor().doubleValue())
                        .sum(),

                "avg" , transacaoRepository.getValores().stream()
                        .mapToDouble(transacao -> transacao.getValor().doubleValue())
                        .average()
                        .orElse(0.0),

                "min", transacaoRepository.getValores().stream()
                        .mapToDouble(transacao -> transacao.getValor().doubleValue())
                        .min()
                        .orElse(0.0),

                "max", transacaoRepository.getValores().stream()
                        .mapToDouble(transacao -> transacao.getValor().doubleValue())
                        .max()
                        .orElse(0.0)
        );
    }

}
