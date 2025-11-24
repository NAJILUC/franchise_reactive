package co.com.franchise.api.dto.response.franchise;

import co.com.franchise.model.franchise.Franchise;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FranchiseResponse {

    private Long id;
    private String name;

    public FranchiseResponse(Franchise franchise) {
        this.id = franchise.getId();
        this.name = franchise.getName();
    }
}
