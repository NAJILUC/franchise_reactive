package co.com.franchise.api.mapper.store;


import co.com.franchise.api.dto.request.store.CreateStoreRequest;
import co.com.franchise.api.dto.response.franchise.FranchiseResponse;
import co.com.franchise.api.dto.response.store.StoreResponse;
import co.com.franchise.model.franchise.Franchise;
import co.com.franchise.model.store.Store;

public class StoreMapper {

    public static Store toModel(CreateStoreRequest dto) {
        return Store.builder()
                .name(dto.getName())
                .build();
    }

    public static StoreResponse toResponse(Store store, Franchise franchise) {
        return StoreResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .franchise(new FranchiseResponse(franchise))
                .build();
    }
}
