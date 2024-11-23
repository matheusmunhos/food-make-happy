package br.com.munhosdev.food_make_happy.service;

import br.com.munhosdev.food_make_happy.domain.Doador;
import br.com.munhosdev.food_make_happy.domain.Endereco;
import br.com.munhosdev.food_make_happy.domain.dto.request.DoadorRequest;
import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import br.com.munhosdev.food_make_happy.domain.enums.TipoUsuario;
import br.com.munhosdev.food_make_happy.exception.DoadorAlreadyExistsException;
import br.com.munhosdev.food_make_happy.exception.DoadorNotFoundException;
import br.com.munhosdev.food_make_happy.repository.DoadorRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import org.springframework.data.geo.Point;

import java.util.List;

@Service
public class DoadorService {

    private final DoadorRepository doadorRepository;
    private final EnderecoService enderecoService;

    public DoadorService(DoadorRepository doadorRepository, EnderecoService enderecoService) {
        this.doadorRepository = doadorRepository;
        this.enderecoService = enderecoService;
    }

    public Doador cadastrarDoador(DoadorRequest doador){
        Doador newDoador = new Doador(doador);
        Doador validacao = doadorRepository.findByCpfCnpj(doador.cpfCnpj());
        if (validacao != null){
            throw new DoadorAlreadyExistsException("CPF/CNPJ Já Cadastrado.");
        }

        if (doador.cpfCnpj().length() > 11){
            newDoador.setTipoUsuario(TipoUsuario.PJ);
        } else {
            newDoador.setTipoUsuario(TipoUsuario.PF);
        }

        Endereco endereco = new Endereco();
        EnderecoResponse enderecoResponse = enderecoService.buscarEndereco(doador.cep());

        endereco.setCep(enderecoResponse.cep());
        endereco.setCidade(enderecoResponse.city());
        endereco.setNumero(doador.numeroEndereco());
        endereco.setComplemento(doador.complemento());
        endereco.setLogradouro(enderecoResponse.address());
        GeoJsonPoint localizacao = new GeoJsonPoint(enderecoResponse.lng(),enderecoResponse.lat());
        newDoador.setLocalizacao(localizacao);
        newDoador.setEndereco(endereco);

        return doadorRepository.save(newDoador);
    }

    public List<Doador> buscarTodos(){
        return doadorRepository.findAll();
    }

    public Doador buscarPorCpfCnpj(String cpfCnpj){
        Doador doador = doadorRepository.findByCpfCnpj(cpfCnpj);
        if(doador == null){
            throw new DoadorNotFoundException("O doador de CPF/CNPJ: "+cpfCnpj+" Não foi encontrado.");
        }
        return doador;
    }

    public void excluir(String cpfCnpj){
        Doador doador = doadorRepository.findByCpfCnpj(cpfCnpj);
        if(doador == null){
            throw new DoadorNotFoundException("O doador de CPF/CNPJ: "+cpfCnpj+" Não foi encontrado.");
        }
        doadorRepository.deleteById(doador.getId());
    }

    public List<Doador> buscarDoadoresProximos(String cep, double distanciaKm) {

        EnderecoResponse coordenadas = enderecoService.buscarEndereco(cep);
        Point pontoCentral = new Point(coordenadas.lng(), coordenadas.lat());
        Distance distancia = new Distance(distanciaKm, Metrics.KILOMETERS);
        return doadorRepository.findByLocalizacaoNear(pontoCentral, distancia);
    }

    public void atualizar(Doador doador){
        doadorRepository.save(doador);
    }
}
