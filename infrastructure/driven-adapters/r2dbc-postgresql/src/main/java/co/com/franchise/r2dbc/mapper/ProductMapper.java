package co.com.franchise.r2dbc.mapper;

import co.com.franchise.model.product.Product;
import co.com.franchise.r2dbc.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity entity) {
        if (entity == null) return null;

        return Product.builder()
                .id(entity.getProductId())
                .name(entity.getName())
                .stock(entity.getStock())
                .build();
    }

    public ProductEntity toEntity(Product product) {
        if (product == null) return null;

        return ProductEntity.builder()
                .productId(product.getId())
                .name(product.getName())
                .stock(product.getStock())
                .build();
    }
}
