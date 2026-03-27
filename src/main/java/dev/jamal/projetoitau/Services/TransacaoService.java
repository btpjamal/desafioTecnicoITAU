package dev.jamal.projetoitau.Services;

import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoDTO transacao){
        if (transacao.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: essa não é uma transação válida, transações devem ter valor superior a zero");
        }
        // verifica se a data não é no futuro
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: a data da transação não é válida");
        }
        // data (presente)
        if(transacao.getValor()== null){
            throw new IllegalArgumentException("Erro: não há valor presente para realizar a operação");
        }
        // hora (presente)
        if (transacao.getDataHora()== null){
            throw new IllegalArgumentException("Erro: não há data e hora presentes para realizar a operação");
        }
    }
}
