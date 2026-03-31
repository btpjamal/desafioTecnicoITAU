package dev.jamal.projetoitau.Repositorys;

import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Repository
public class TransacaoRepository{

    private final List<TransacaoDTO> transacoesList= new ArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public TransacaoRepository(){
        // agenda a limpeza a cada 60 secs
        scheduler.scheduleAtFixedRate(this::limparDados, 60, 60, TimeUnit.SECONDS);
    }

    // salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){
        transacoesList.add(transacaoDTO);
    }

    // apagar lista após 60 segs.
    public void limparDados(){
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(60);
        transacoesList.removeIf(t -> t.getDataHora().isBefore(limite));
    }

    // apagar todas as transações da lista
    public void deletarDados(){
        transacoesList.clear();
    }

    public List<TransacaoDTO> getValores(){
        return transacoesList;
    }
}
