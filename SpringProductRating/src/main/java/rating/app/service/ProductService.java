package rating.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rating.app.dto.ProductDto;
import rating.app.dto.ProductReviewForm;
import rating.app.mapper.ProductMapper;
import rating.app.product.Product;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    private final Map<Long, Product> idToProduct;
    private final ProductMapper mapper;

    @Autowired
    public ProductService(ProductMapper mapper) {
        idToProduct = new HashMap<>(Map.of(
                1L, new Product("Laptop"),
                2L, new Product("Phone")
        ));

        this.mapper = new ProductMapper();
    }

    public ProductDto getProductDto(long id) {
        Product product = idToProduct.get(id);
        return mapper.productDto(product);
    }

    public void addReview(ProductReviewForm form) {
        Product product = idToProduct.get(form.getId());
        product.addReview(form.getRating(), form.getComment());
    }
    public Product getById(long id){
        return idToProduct.get(id);
    }
}
