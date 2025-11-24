package co.com.franchise.api.mapper.franchise;


import co.com.franchise.api.dto.request.franchise.CreateFranchiseRequest;
import co.com.franchise.api.dto.response.franchise.FranchiseResponse;
import co.com.franchise.model.franchise.Franchise;

public class FranchiseMapper {

    public static Franchise toModel(CreateFranchiseRequest dto) {
        return Franchise.builder()
                .name(dto.getName())
                .build();
    }

    public static FranchiseResponse toResponse(Franchise franchise) {
        return FranchiseResponse.builder()
                .id(franchise.getId())
                .name(franchise.getName())
                .build();
    }
}
