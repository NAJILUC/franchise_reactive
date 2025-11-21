package co.com.franchise.model.franchise;

import co.com.franchise.model.store.Store;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Franchise {
    private Long id;
    private String name;
    private List<Store> stores;
}
