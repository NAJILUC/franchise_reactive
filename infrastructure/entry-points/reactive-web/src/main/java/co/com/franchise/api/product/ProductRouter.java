package co.com.franchise.api.product;

import co.com.franchise.api.store.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ProductRouter {

    @Bean
    public RouterFunction<ServerResponse> productRoutes(ProductHandler handler) {
        return RouterFunctions.route()
                .POST("/products", handler::saveProduct)
                .GET("/products/{id}", handler::findById)
                .GET("/products/store/{storeId}", handler::findByStoreId)
                .build();
    }
}
