package br.com.munhosdev.food_make_happy.service;

import br.com.munhosdev.food_make_happy.domain.Doacoes;
import br.com.munhosdev.food_make_happy.domain.dto.request.DoacaoRequest;
import br.com.munhosdev.food_make_happy.repository.DoacoesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoacoesService {

    private final DoacoesRepository repository;
    private final DoadorService doadorService;
    private final ReceptorService receptorService;

    public DoacoesService(DoacoesRepository repository, DoadorService doadorService, ReceptorService receptorService) {
        this.repository = repository;
        this.doadorService = doadorService;
        this.receptorService = receptorService;
    }

    public Doacoes doar(DoacaoRequest request) {
        Doacoes doacao = new Doacoes(request);
        var doador = doadorService.buscarPorCpfCnpj(request.doadorCpfCnpj());
        var receptor = receptorService.buscarPorCpfCnpj(request.recptorCpfCnpj());
        doacao.setDoador(doador);
        doacao.setReceptor(receptor);
        List<Doacoes> doacoes = doador.getDoacoesRealizadas();
        if (doacoes == null) {
            doacoes = new ArrayList<>();
        }
        doacoes.add(doacao);
        doador.setDoacoesRealizadas(doacoes);
        doadorService.atualizar(doador);

        return repository.save(doacao);
    }


    public List<Doacoes> buscarTodasDoacoes(){
        return repository.findAll();
    }
}
