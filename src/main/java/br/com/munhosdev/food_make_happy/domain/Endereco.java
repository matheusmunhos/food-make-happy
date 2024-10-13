package br.com.munhosdev.food_make_happy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
}
