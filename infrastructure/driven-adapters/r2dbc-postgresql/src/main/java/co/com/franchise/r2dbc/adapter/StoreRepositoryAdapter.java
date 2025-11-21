package co.com.franchise.r2dbc.adapter;

import co.com.franchise.model.store.Store;
import co.com.franchise.model.store.gateways.StoreRepository;
import co.com.franchise.r2dbc.entity.StoreEntity;
import co.com.franchise.r2dbc.mapper.StoreMapper;
import co.com.franchise.r2dbc.repository.StoreReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryAdapter implements StoreRepository {

    private final StoreReactiveRepository storeReactiveRepository;
    private final StoreMapper storeMapper;

    @Override
    public Mono<Store> save(Store store) {
        StoreEntity entity = storeMapper.toEntity(store);

        return storeReactiveRepository.save(entity)
                .map(storeMapper::toDomain);
    }

    @Override
    public Mono<Store> findById(Long id) {
        return storeReactiveRepository.findById(id)
                .map(storeMapper::toDomain);
    }

    @Override
    public Flux<Store> findAll() {
        return storeReactiveRepository.findAll()
                .map(storeMapper::toDomain);
    }
}
