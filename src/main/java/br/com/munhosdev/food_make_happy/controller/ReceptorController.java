package br.com.munhosdev.food_make_happy.controller;

import br.com.munhosdev.food_make_happy.domain.Receptor;
import br.com.munhosdev.food_make_happy.domain.dto.request.ReceptorRequest;
import br.com.munhosdev.food_make_happy.service.ReceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/receptor")
public class ReceptorController {

    @Autowired
    private ReceptorService receptorService;

    @PostMapping("/cadastrar")
    public Receptor cadastrarReceptor(@RequestBody ReceptorRequest request){
        return receptorService.cadastrarDoador(request);
    }

    @GetMapping("/{cpfCnpj}")
    public Receptor buscarPorCpfCnpj(@PathVariable String cpfCnpj){
        return receptorService.buscarPorCpfCnpj(cpfCnpj);
    }

    @GetMapping
    public List<Receptor> buscarTodos(){
        return receptorService.buscarTodos();
    }

    @DeleteMapping("/{cpfCnpj}")
    public void excluir(@PathVariable String cpfCnpj){
        receptorService.exluir(cpfCnpj);
    }
}
