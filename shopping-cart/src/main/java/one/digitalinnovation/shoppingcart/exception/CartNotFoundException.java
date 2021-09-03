package one.digitalinnovation.shoppingcart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartNotFoundException extends Exception {

    public CartNotFoundException(Long idCart) {
        super("Cart ID: " + idCart + " not found");
    }
}
