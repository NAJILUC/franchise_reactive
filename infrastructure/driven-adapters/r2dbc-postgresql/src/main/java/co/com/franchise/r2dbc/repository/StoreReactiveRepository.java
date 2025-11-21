package co.com.franchise.r2dbc.repository;

import co.com.franchise.r2dbc.entity.StoreEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StoreReactiveRepository extends ReactiveCrudRepository<StoreEntity, Long> {

    Flux<StoreEntity> findByFranchiseId(Long franchiseId);
}
