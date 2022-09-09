package sinofuncionamemato.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sinofuncionamemato.business.entities.Restaurante;
import sinofuncionamemato.business.exceptions.InvalidInformation;
import sinofuncionamemato.business.exceptions.RestaurantAlreadyExists;
import sinofuncionamemato.persistence.RestauranteRepository;


@Service
public class RestaurantService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public void guardarRestaurante(Restaurante restaurante) throws RestaurantAlreadyExists, InvalidInformation {
        if (restaurante.getName() == null || restaurante.getName().equals("")||
        restaurante.getTelefono() == null || restaurante.getTelefono().equals("")||
        restaurante.getDireccion() == null || restaurante.getDireccion().equals("")) {
            throw new InvalidInformation("Informacion Invalida");
        }
        if (restauranteRepository.findRestauranteByName(restaurante.getName()) != null){
            throw new RestaurantAlreadyExists("El restaurante ya existe");
        }

        restauranteRepository.save(restaurante);



    }


}
