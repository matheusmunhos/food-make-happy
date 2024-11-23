package br.com.munhosdev.food_make_happy.controller;

import br.com.munhosdev.food_make_happy.domain.Doacoes;
import br.com.munhosdev.food_make_happy.domain.dto.request.DoacaoRequest;
import br.com.munhosdev.food_make_happy.service.DoacoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    private final DoacoesService service;

    public DoacaoController(DoacoesService service) {
        this.service = service;
    }

    @PostMapping("/doar")
    public Doacoes doar(@RequestBody DoacaoRequest request){
        return service.doar(request);
    }

    @GetMapping("/buscar")
    public List<Doacoes> buscarTodasDoacoes(){
        return service.buscarTodasDoacoes();
    }
}
