package co.com.franchise.api.dto.response.store;

import co.com.franchise.api.dto.response.franchise.FranchiseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreResponse {

    private Long id;
    private String name;
    private FranchiseResponse franchise;
}
