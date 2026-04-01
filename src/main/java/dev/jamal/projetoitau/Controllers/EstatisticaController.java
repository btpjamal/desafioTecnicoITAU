package dev.jamal.projetoitau.Controllers;

import dev.jamal.projetoitau.Services.EstatisticaService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@Slf4j
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping("/getEstatistica")
    public ResponseEntity estatisticas(){
        log.warn("gerando estatísticas...");
        return ResponseEntity.ok().body(estatisticaService.getEstatistica());
    }
}
