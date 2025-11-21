package co.com.franchise.api.store;

import co.com.franchise.model.product.Product;
import co.com.franchise.model.store.Store;
import co.com.franchise.usecase.product.ProductUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductUseCase productUseCase;

    public Mono<ServerResponse> saveProduct(ServerRequest request) {
        return request.bodyToMono(Product.class)
                .flatMap(productUseCase::saveProduct)
                .flatMap(saved ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(saved)
                );
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));

        return productUseCase.findById(id)
                .flatMap(store ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(store)
                )
                .switchIfEmpty(
                        ServerResponse.notFound().build()
                );
    }

    public Mono<ServerResponse> findByStoreId(ServerRequest request) {
        Long storeId = Long.valueOf(request.pathVariable("storeId"));
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productUseCase.findByStoreId(storeId), Product.class);
    }
}