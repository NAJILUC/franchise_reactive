package co.com.franchise.model.store;

import co.com.franchise.model.product.Product;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Store {
    private Long id;
    private String name;
    private List<Product> products;

    private Long franchiseId;
}
