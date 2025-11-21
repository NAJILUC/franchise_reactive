package co.com.franchise.api.franchise;

import co.com.franchise.model.franchise.Franchise;
import co.com.franchise.usecase.franchise.FranchiseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FranchiseHandler {

    private final FranchiseUseCase franchiseUseCase;

    public Mono<ServerResponse> create(ServerRequest req) {
        return req.bodyToMono(Franchise.class)
                .flatMap(franchiseUseCase::saveFranchise)
                .flatMap(franchise -> ServerResponse.ok().bodyValue(franchise));
    }
    
}
