package rating.app.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class Product {
    private final String name;
    private final List<Map<Double, String>> reviews;

    public Product(String name) {
        this.name = name;
        reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Map<Double, String>> getReviews() {
        return reviews;
    }

    public void addReview(double rating, String comment) {
        Map<Double, String> review = Map.of(rating, comment);
        reviews.add(review);
    }
}
