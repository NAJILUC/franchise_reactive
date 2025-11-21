package co.com.franchise.r2dbc.adapter;

import co.com.franchise.model.product.Product;
import co.com.franchise.model.product.gateways.ProductRepository;
import co.com.franchise.r2dbc.mapper.ProductMapper;
import co.com.franchise.r2dbc.repository.ProductReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductReactiveRepository productReactiveRepository;
    private final ProductMapper productMapper;

    @Override
    public Mono<Product> save(Product product) {
        return productReactiveRepository.save(productMapper.toEntity(product))
                .map(productMapper::toDomain);
    }

    @Override
    public Mono<Product> findById(Long productId) {
        return productReactiveRepository.findById(productId)
                .map(productMapper::toDomain);
    }

    @Override
    public Flux<Product> findByStoreId(Long productId) {
        return productReactiveRepository.findByStoreId(productId)
                .map(productMapper::toDomain);
    }
}
