package br.com.munhosdev.food_make_happy.repository;

import br.com.munhosdev.food_make_happy.domain.Doador;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Distance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoadorRepository extends MongoRepository<Doador,String> {

    Doador findByCpfCnpj(String cpfCnpj);

    List<Doador> findByLocalizacaoNear(Point location, Distance distance);
}
