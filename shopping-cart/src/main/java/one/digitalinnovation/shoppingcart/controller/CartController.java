package one.digitalinnovation.shoppingcart.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.shoppingcart.dto.response.MessageResponseDTO;
import one.digitalinnovation.shoppingcart.exception.CartNotFoundException;
import one.digitalinnovation.shoppingcart.model.Cart;
import one.digitalinnovation.shoppingcart.model.Item;
import one.digitalinnovation.shoppingcart.repository.CartRepository;
import one.digitalinnovation.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartController {

    CartService cartService;

    @PostMapping("/{idCart}")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO addItem(@PathVariable Long idCart, @RequestBody Item item) throws CartNotFoundException {
        return cartService.addItem(idCart, item);
    }

    @GetMapping("/{idCart}")
    public MessageResponseDTO findById(@PathVariable Long idCart) throws CartNotFoundException {
        return cartService.findById(idCart);
    }

    @DeleteMapping("/{idCart}")
    public MessageResponseDTO deleteByID(@PathVariable Long idCart) throws CartNotFoundException {
        return cartService.delete(idCart);
    }
}
