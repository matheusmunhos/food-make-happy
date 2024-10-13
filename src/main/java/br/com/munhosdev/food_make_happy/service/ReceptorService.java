package br.com.munhosdev.food_make_happy.service;

import br.com.munhosdev.food_make_happy.domain.Doador;
import br.com.munhosdev.food_make_happy.domain.Endereco;
import br.com.munhosdev.food_make_happy.domain.Receptor;
import br.com.munhosdev.food_make_happy.domain.dto.request.DoadorRequest;
import br.com.munhosdev.food_make_happy.domain.dto.request.ReceptorRequest;
import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import br.com.munhosdev.food_make_happy.domain.enums.TipoUsuario;
import br.com.munhosdev.food_make_happy.repository.ReceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptorService {

    @Autowired
    private ReceptorRepository receptorRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Receptor cadastrarDoador(ReceptorRequest receptor){
        Receptor newReceptor = new Receptor(receptor);
        Receptor validacao = receptorRepository.findByCpfCnpj(receptor.cpfCnpj());
        if (validacao != null){
            throw new RuntimeException("CPF/CNPJ Já Cadastrado.");
        }

        if (receptor.cpfCnpj().length() > 11){
            newReceptor.setTipoUsuario(TipoUsuario.PJ);
        } else {
            newReceptor.setTipoUsuario(TipoUsuario.PF);
        }

        Endereco endereco = new Endereco();
        EnderecoResponse enderecoResponse = enderecoService.buscarEndereco(receptor.cep());

        endereco.setCep(enderecoResponse.cep());
        endereco.setCidade(enderecoResponse.city());
        endereco.setNumero(receptor.numeroEndereco());
        endereco.setComplemento(receptor.complemento());
        endereco.setLogradouro(enderecoResponse.address());
        GeoJsonPoint localizacao = new GeoJsonPoint(enderecoResponse.lng(),enderecoResponse.lat());
        newReceptor.setLocalizacao(localizacao);
        newReceptor.setEndereco(endereco);

        return receptorRepository.save(newReceptor);
    }

    public Receptor buscarPorCpfCnpj(String cpfCnpj){
        return receptorRepository.findByCpfCnpj(cpfCnpj);
    }

    public List<Receptor> buscarTodos() {
        return receptorRepository.findAll();
    }

    public void exluir(String cpfCnpj) {
        Receptor receptor = receptorRepository.findByCpfCnpj(cpfCnpj);
        receptorRepository.deleteById(receptor.getId());
    }
}
