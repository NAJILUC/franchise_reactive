package co.com.franchise.api.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class StoreRouter {

    @Bean
    public RouterFunction<ServerResponse> storeRoutes(StoreHandler handler) {
        return RouterFunctions.route()
                .POST("/stores", handler::saveStore)
                .GET("/stores/{id}", handler::findById)
                .GET("/stores", handler::findAll)
                .build();
    }
}