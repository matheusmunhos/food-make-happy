package br.com.munhosdev.food_make_happy.domain;

import br.com.munhosdev.food_make_happy.domain.dto.request.DoacaoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "doacoes")
public class Doacoes {

    @MongoId
    private String id;

    private String alimento;
    private Integer quantidade;
    private LocalDate validade;
    private Boolean lacrado;
    private Double valorEstimado;
    @DBRef
    private Doador doador;
    @DBRef
    private Receptor receptor;

    public Doacoes (DoacaoRequest request){
        this.alimento = request.alimento();
        this.quantidade = request.quantidade();
        this.validade = request.validade();
        this.lacrado = request.lacrado();
        this.valorEstimado = request.valorEstimado();
    }
}
