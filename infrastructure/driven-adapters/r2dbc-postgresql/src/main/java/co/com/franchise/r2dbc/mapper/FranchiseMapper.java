package co.com.franchise.r2dbc.mapper;

import co.com.franchise.model.franchise.Franchise;
import co.com.franchise.r2dbc.entity.FranchiseEntity;
import org.springframework.stereotype.Component;

@Component
public class FranchiseMapper {

    public Franchise toDomain(FranchiseEntity entity) {
        if (entity == null) return null;

        return Franchise.builder()
                .id(entity.getFranchiseId())
                .name(entity.getName())
                .build();
    }

    public FranchiseEntity toEntity(Franchise franchise) {
        if (franchise == null) return null;

        return FranchiseEntity.builder()
                .franchiseId(franchise.getId())
                .name(franchise.getName())
                .build();
    }
}
