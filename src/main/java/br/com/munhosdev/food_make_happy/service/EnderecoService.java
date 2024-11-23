package br.com.munhosdev.food_make_happy.service;

import br.com.munhosdev.food_make_happy.client.EnderecoClient;
import br.com.munhosdev.food_make_happy.domain.dto.response.EnderecoResponse;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoClient enderecoClient;

    public EnderecoService(EnderecoClient enderecoClient) {
        this.enderecoClient = enderecoClient;
    }

    public EnderecoResponse buscarEndereco(String cep){
        return enderecoClient.getEndereco(cep);
    }
}
