package co.com.franchise.usecase.franchise;

import co.com.franchise.model.franchise.Franchise;
import co.com.franchise.model.franchise.gateways.FranchiseRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranchiseRepository franchiseRepository;

    public Mono<Franchise> saveFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Mono<Franchise> findById(Long id) {
        return franchiseRepository.findById(id);
    }
}
