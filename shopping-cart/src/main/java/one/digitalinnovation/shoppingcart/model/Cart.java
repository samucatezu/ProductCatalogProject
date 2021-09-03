package one.digitalinnovation.shoppingcart.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@RedisHash("cart")
public class Cart {

    @Id
    private Long id;
    private List<Item> items;

}
