package one.digitalinnovation.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@RedisHash("item")
public class Item {

    private Integer productId;
    private Integer amount;
}
