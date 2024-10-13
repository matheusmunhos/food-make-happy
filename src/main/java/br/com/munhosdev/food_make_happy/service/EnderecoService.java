package br.com.munhosdev.food_make_happy.service;

import br.com.munhosdev.food_make_happy.client.EnderecoClient;
import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoClient enderecoClient;

    public EnderecoResponse buscarEndereco(String cep){
        return enderecoClient.getEndereco(cep);
    }
}
