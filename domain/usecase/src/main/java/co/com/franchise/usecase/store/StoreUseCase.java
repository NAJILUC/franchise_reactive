package co.com.franchise.usecase.store;

import co.com.franchise.model.store.Store;
import co.com.franchise.model.store.gateways.StoreRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class StoreUseCase {

    private final StoreRepository storeRepository;

    public Mono<Store> saveStore(Store store) {
        return storeRepository.save(store);
    }

    public Mono<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    public Flux<Store> findAll() {
        return storeRepository.findAll();
    }
}
