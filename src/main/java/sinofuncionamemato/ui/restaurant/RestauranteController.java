package sinofuncionamemato.ui.restaurant;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sinofuncionamemato.business.RestaurantService;
import sinofuncionamemato.business.entities.Restaurante;
import sinofuncionamemato.business.exceptions.InvalidInformation;
import sinofuncionamemato.business.exceptions.RestaurantAlreadyExists;



@Component
public class RestauranteController {

    @Autowired
    RestaurantService restaurantMgr;

    @FXML
    Button cancelar;

    @FXML
    Button guardar;

    @FXML
    TextField nombre;

    @FXML
    TextField telefono;

    @FXML
    TextField direccion;

    @FXML
    void guardarRestaurante(ActionEvent event){
        if (nombre.getText() == null || nombre.getText().equals("") || telefono.getText() == null ||
        telefono.getText().equals("") || direccion.getText() == null || direccion.getText().equals("")){
            showAlert("Faltan datos!", "No ha ingresado todos los datos necesarios");

        }else{
            String nombreR = nombre.getText();
            String telefonoR = telefono.getText();
            String direccionR = direccion.getText();

            try {
                Restaurante restaurante = new Restaurante(nombreR,telefonoR,direccionR);
                restaurantMgr.guardarRestaurante(restaurante);
                showAlert("Restuarante creado", "el restaurante ha sido creado con exito");

            }catch (InvalidInformation e){
                showAlert("Informacion Invalida!", "la informacion ingresada no es valida");
            }catch (RestaurantAlreadyExists e){
                showAlert("Ya existe", "el restaurante ya existe");
            }

        }
    }

    private void showAlert(String title, String contextText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contextText);
        alert.showAndWait();
    }

}
