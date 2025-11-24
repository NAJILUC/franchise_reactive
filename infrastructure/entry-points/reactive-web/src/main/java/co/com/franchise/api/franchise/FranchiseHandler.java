package co.com.franchise.api.franchise;

import co.com.franchise.api.dto.request.franchise.CreateFranchiseRequest;
import co.com.franchise.api.dto.request.store.CreateStoreRequest;
import co.com.franchise.api.dto.response.franchise.FranchiseResponse;
import co.com.franchise.api.mapper.franchise.FranchiseMapper;
import co.com.franchise.api.mapper.store.StoreMapper;
import co.com.franchise.model.store.Store;
import co.com.franchise.usecase.franchise.FranchiseUseCase;
import co.com.franchise.usecase.store.StoreUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchiseHandler {

    private final FranchiseUseCase franchiseUseCase;
    private final StoreUseCase  storeUseCase;

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(CreateFranchiseRequest.class)
                .flatMap(dto -> franchiseUseCase.saveFranchise(FranchiseMapper.toModel(dto)))
                .flatMap(franchise -> ServerResponse.ok().bodyValue(FranchiseMapper.toResponse(franchise)));
    }

    public Mono<ServerResponse> findAll(ServerRequest req) {
        return ServerResponse.ok()
                .body(franchiseUseCase.findAll().map(FranchiseMapper::toResponse),
                        FranchiseResponse.class);
    }

    public Mono<ServerResponse> findAllStream(ServerRequest request) {
        Flux<FranchiseResponse> flux = franchiseUseCase.findAll().map(FranchiseMapper::toResponse);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(flux, FranchiseResponse.class);
    }

    public Mono<ServerResponse> createStore(ServerRequest request) {
        Long franchiseId = Long.valueOf(request.pathVariable("id"));

        return franchiseUseCase.findById(franchiseId)
                .switchIfEmpty(Mono.error(new Exception("Franchise not found")))
                .flatMap(franchise ->
                        request.bodyToMono(CreateStoreRequest.class)
                                .map(StoreMapper::toModel)
                                .map(store -> store.toBuilder()
                                        .franchiseId(franchiseId)
                                        .build())
                                .flatMap(storeUseCase::saveStore)
                                .flatMap(store ->
                                        ServerResponse.ok()
                                                .bodyValue(StoreMapper.toResponse(store, franchise))
                                )
                );
    }
    
}
