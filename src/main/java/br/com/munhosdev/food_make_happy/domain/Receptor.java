package br.com.munhosdev.food_make_happy.domain;

import br.com.munhosdev.food_make_happy.domain.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.awt.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "receptores")
public class Receptor {

    @MongoId
    private String id;
    private String nome;
    private String cpf;
    @DBRef
    private Endereco endereco;
    private Point localizacao;
    private Contato contato;
    private TipoUsuario tipoUsuario;
    private List<Doacoes> doacoesRecebidas;
}
