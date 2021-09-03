package one.digitalinnovation.shoppingcart.dto.response;

import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.shoppingcart.model.Cart;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
    private Cart object;
}
