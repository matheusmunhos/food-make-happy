package br.com.munhosdev.food_make_happy.domain.dto.request;

import br.com.munhosdev.food_make_happy.domain.Contato;

public record DoadorRequest(
        String nome,
        String cpfCnpj,
        String cep,
        String numeroEndereco,
        String complemento,
        Contato contato
) {
}
