package sinofuncionamemato.persistence;

import org.springframework.data.repository.CrudRepository;
import sinofuncionamemato.business.entities.Restaurante;

public interface RestauranteRepository extends CrudRepository<Restaurante,String> {

    Restaurante findRestauranteByName(String name);

}
