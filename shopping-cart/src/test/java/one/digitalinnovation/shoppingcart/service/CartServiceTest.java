package one.digitalinnovation.shoppingcart.service;

import one.digitalinnovation.shoppingcart.model.Cart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CartServiceTest {

    @Test
    public void testAddItem() {
        var cart = Cart.builder()
                .id(20L)
                .items(new ArrayList<>())
                .build();

        System.out.println(cart);
    }
}
