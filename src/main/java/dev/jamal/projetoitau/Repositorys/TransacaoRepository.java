package dev.jamal.projetoitau.Repositorys;

import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Repository
@Slf4j
public class TransacaoRepository{

    private final List<TransacaoDTO> transacoesList= new ArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Value("${estatistica.tempo}")
    private int tempo;

    @PostConstruct
    public void init() {
        if (tempo > 0) {
            scheduler.scheduleAtFixedRate(this::limparDados, tempo, tempo, TimeUnit.SECONDS);
            log.info("Agendamento configurado para "+ tempo +" segundos");
        }
    }


    // salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){
        log.warn("dados salvos");
        transacoesList.add(transacaoDTO);
    }

    // apagar lista após 60 segs.
    public void limparDados(){
        OffsetDateTime limite = OffsetDateTime.now().minusSeconds(tempo);
        transacoesList.removeIf(t -> t.getDataHora().isBefore(limite));
        log.warn("lista resetada");
    }

    // apagar todas as transações da lista
    public void deletarDados(){
        transacoesList.clear();
    }

    public List<TransacaoDTO> getValores(){
        return transacoesList;
    }
}
