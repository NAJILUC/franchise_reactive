package co.com.franchise.r2dbc.repository;

import co.com.franchise.r2dbc.entity.ProductEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductReactiveRepository extends ReactiveCrudRepository<ProductEntity, Long> {

    Flux<ProductEntity> findByStoreId(Long storeId);
}
