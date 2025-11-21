package co.com.franchise.usecase.product;

import co.com.franchise.model.product.Product;
import co.com.franchise.model.product.gateways.ProductRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductUseCase {

    private final ProductRepository productRepository;

    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Flux<Product> findByStoreId(Long storeId) {
        return productRepository.findByStoreId(storeId);
    }
}
