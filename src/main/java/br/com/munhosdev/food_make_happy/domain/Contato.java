package br.com.munhosdev.food_make_happy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private String telefone;
    private String email;
    private String observacao;
}
