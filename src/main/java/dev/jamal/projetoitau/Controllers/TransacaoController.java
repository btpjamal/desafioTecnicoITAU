package dev.jamal.projetoitau.Controllers;

import dev.jamal.projetoitau.DTOS.TransacaoDTO;
import dev.jamal.projetoitau.Repositorys.TransacaoRepository;
import dev.jamal.projetoitau.Services.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping("/adicionar")
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacao){
        // tenta validar a transacao
        try {
            transacaoService.validarTransacao(transacao);
            transacaoRepository.salvarDados(transacao);
            return ResponseEntity.ok(transacao).status(HttpStatus.CREATED).build();

        } catch (IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity deletar(){
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
