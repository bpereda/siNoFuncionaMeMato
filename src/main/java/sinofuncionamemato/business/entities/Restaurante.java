package sinofuncionamemato.business.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurante {
    @Id
    private String name;
    private String telefono;
    private String direccion;

    public Restaurante(String name, String telefono, String direccion) {
        this.name = name;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Restaurante() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "name='" + name + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
