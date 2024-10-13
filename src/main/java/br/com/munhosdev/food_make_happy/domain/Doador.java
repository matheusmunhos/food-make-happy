package br.com.munhosdev.food_make_happy.domain;

import br.com.munhosdev.food_make_happy.domain.dto.request.DoadorRequest;
import br.com.munhosdev.food_make_happy.domain.enums.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "doadores")
public class Doador {

    @MongoId
    private String id;
    private String nome;
    private String cpfCnpj;
    private Endereco endereco;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint localizacao;
    private Contato contato;
    private TipoUsuario tipoUsuario;
    private List<Doacoes> doacoesRealizadas;

    public Doador(DoadorRequest request){
        this.nome = request.nome();
        this.cpfCnpj = request.cpfCnpj();
        this.contato = request.contato();
    }
}