package co.com.franchise.api.franchise;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class FranchiseRouter {

    @Bean
    public RouterFunction<ServerResponse> route(FranchiseHandler handler) {
        return RouterFunctions.route()
                .GET("/franchises", handler::findAll)
                .GET("/franchises/stream", handler::findAllStream)
                .POST("/franchises", handler::create)
                .POST("/franchises/{id}/store", handler::createStore)
                .build();
    }
}
