package br.com.munhosdev.food_make_happy.controller;

import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import br.com.munhosdev.food_make_happy.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> buscarEndereco(@PathVariable String cep){
        return ResponseEntity.ok(service.buscarEndereco(cep));
    }
}
