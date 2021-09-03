package one.digitalinnovation.shoppingcart.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.shoppingcart.dto.response.MessageResponseDTO;
import one.digitalinnovation.shoppingcart.exception.CartNotFoundException;
import one.digitalinnovation.shoppingcart.model.Cart;
import one.digitalinnovation.shoppingcart.model.Item;
import one.digitalinnovation.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartService {

    CartRepository cartRepository;

    public MessageResponseDTO addItem(Long idCart, Item item) throws CartNotFoundException {
        Optional<Cart> savedCart = cartRepository.findById(idCart);
        Cart cart;

        if(savedCart.isPresent()){
            //  Cart Found
            cart = savedCart.get();
        } else {
            //  Cart Not Found
            cart = Cart.builder()
                    .id(idCart)
                    .items(new ArrayList<>())
                    .build();
        }

        cart.getItems().add(item);  //  Add item to cart
        cartRepository.save(cart);  //  Save cart

        return createMessageResponse(("Added Item ID: " + item.getProductId()), cart);
    }

    public MessageResponseDTO findById(Long id) throws CartNotFoundException {
        verifyIfExists(id);

        var result = cartRepository.findById(id);
        return createMessageResponse(("Found Cart ID: " + id), result.get());
    }

    public MessageResponseDTO delete(Long idCart) throws CartNotFoundException {
        var result = verifyIfExists(idCart);
        cartRepository.deleteById(idCart);

        return createMessageResponse(("Deleted Cart ID: " + result.getId()), result);
    }

    //  Private Methods

    private Cart verifyIfExists(Long id) throws CartNotFoundException {
        return cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String msg, Cart cart) {
        return MessageResponseDTO
                .builder()
                .message(msg)
                .object(cart)
                .build();
    }


}
