package rating.app.mapper;

import org.springframework.stereotype.Component;
import rating.app.dto.ProductDto;
import rating.app.product.Product;

@Component
public class ProductMapper {
    public ProductDto productDto(Product product) {
        return new ProductDto(product.getName(), getAvgRating(product), product.getReviews().size());
    }

    private double getAvgRating(Product product) {
        return product.getReviews().stream()
                .flatMapToDouble(doubleStringMap -> doubleStringMap.keySet().stream().mapToDouble(Double::doubleValue))
                .average()
                .orElse(0.0);
    }
}
