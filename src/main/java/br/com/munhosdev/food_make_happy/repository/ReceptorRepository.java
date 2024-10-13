package br.com.munhosdev.food_make_happy.repository;

import br.com.munhosdev.food_make_happy.domain.Receptor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceptorRepository extends MongoRepository<Receptor,String> {

    Receptor findByCpfCnpj(String cpfCnpj);
}
