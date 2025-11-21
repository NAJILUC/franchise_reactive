package co.com.franchise.r2dbc.adapter;

import co.com.franchise.model.franchise.Franchise;
import co.com.franchise.model.franchise.gateways.FranchiseRepository;
import co.com.franchise.r2dbc.mapper.FranchiseMapper;
import co.com.franchise.r2dbc.repository.FranchiseReactiveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranchiseRepositoryAdapter implements FranchiseRepository {

    private final FranchiseReactiveRepository franchiseReactiveRepository;
    private final FranchiseMapper franchiseMapper;

    @Override
    public Mono<Franchise> save(Franchise franchise) {
        return franchiseReactiveRepository.save(franchiseMapper.toEntity(franchise))
                .map(franchiseMapper::toDomain);
    }

    @Override
    public Mono<Franchise> findById(Long franchiseId) {
        return franchiseReactiveRepository.findById(franchiseId)
                .map(franchiseMapper::toDomain);
    }
}
