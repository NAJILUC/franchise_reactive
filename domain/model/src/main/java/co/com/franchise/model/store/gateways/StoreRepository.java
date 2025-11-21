package co.com.franchise.model.store.gateways;

import co.com.franchise.model.store.Store;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StoreRepository {
    Mono<Store> save(Store store);
    Mono<Store> findById(Long id);
    Flux<Store> findAll();
}
