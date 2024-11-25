package br.com.munhosdev.food_make_happy.controller;

import br.com.munhosdev.food_make_happy.domain.Doador;
import br.com.munhosdev.food_make_happy.domain.dto.request.DoadorRequest;
import br.com.munhosdev.food_make_happy.service.DoadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    private final DoadorService service;

    public DoadorController(DoadorService service) {
        this.service = service;
    }

    @PostMapping("/cadastrar")
    public Doador cadastrarDoador(@RequestBody DoadorRequest doador){
        return service.cadastrarDoador(doador);
    }

    @GetMapping("/{cpfCnpj}")
    public Doador buscarPorCpfCnpj(@PathVariable String cpfCnpj){
        return service.buscarPorCpfCnpj(cpfCnpj);
    }

    @GetMapping("/{cep}/{km}")
    public List<Doador> buscarDoadoresProximos(@PathVariable double km, @PathVariable String cep){
        return service.buscarDoadoresProximos(cep,km);
    }

    @GetMapping
    public List<Doador> buscarTodos(){
        return service.buscarTodos();
    }

    @DeleteMapping("/{cpfCnpj}")
    public void excluir(@PathVariable String cpfCnpj){
        service.excluir(cpfCnpj);
    }
}
