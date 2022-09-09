package sinofuncionamemato.business.exceptions;

public class RestaurantAlreadyExists extends Exception{
    public RestaurantAlreadyExists(String message) {
        super(message);
    }

    public RestaurantAlreadyExists() {
    }
}
