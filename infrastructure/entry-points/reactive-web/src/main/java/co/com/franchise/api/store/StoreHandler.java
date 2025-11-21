package co.com.franchise.api.store;

import co.com.franchise.model.store.Store;
import co.com.franchise.usecase.store.StoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StoreHandler {

    private final StoreUseCase storeUseCase;

    public Mono<ServerResponse> saveStore(ServerRequest request) {
        return request.bodyToMono(Store.class)
                .flatMap(storeUseCase::saveStore)
                .flatMap(saved ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(saved)
                );
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Long id = Long.valueOf(request.pathVariable("id"));

        return storeUseCase.findById(id)
                .flatMap(store ->
                        ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(store)
                )
                .switchIfEmpty(
                        ServerResponse.notFound().build()
                );
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(storeUseCase.findAll(), Store.class);
    }
}