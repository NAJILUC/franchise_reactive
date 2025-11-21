package co.com.franchise.r2dbc.mapper;

import co.com.franchise.model.store.Store;
import co.com.franchise.r2dbc.entity.StoreEntity;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public Store toDomain(StoreEntity entity) {
        if (entity == null) return null;

        return Store.builder()
                .id(entity.getStoreId())
                .name(entity.getName())
                .franchiseId(entity.getFranchiseId())
                .build();
    }

    public StoreEntity toEntity(Store store) {
        if (store == null) return null;

        return StoreEntity.builder()
                .storeId(store.getId())
                .name(store.getName())
                .franchiseId(store.getFranchiseId())
                .build();
    }
}
