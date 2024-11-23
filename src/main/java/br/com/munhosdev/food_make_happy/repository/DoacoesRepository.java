package br.com.munhosdev.food_make_happy.repository;

import br.com.munhosdev.food_make_happy.domain.Doacoes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoacoesRepository extends MongoRepository<Doacoes, String> {
}
