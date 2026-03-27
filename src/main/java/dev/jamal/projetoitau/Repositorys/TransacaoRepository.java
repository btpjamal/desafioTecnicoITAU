package dev.jamal.projetoitau.Repositorys;

import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TransacaoRepository{

    List<TransacaoDTO> transacoesList= new ArrayList<>();

    // salvar os dados em uma lista
    public void salvarDados(TransacaoDTO transacaoDTO){
        transacoesList.add(transacaoDTO);
    }
    // apagar lista após 60 segs.
    public void limparDados(TransacaoDTO transacaoDTO){

    }
    // apagar todas as transações da lista
    public void deletarDados(){
        transacoesList.clear();
    }
}
