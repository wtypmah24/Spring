package rating.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rating.app.dto.ProductDto;
import rating.app.dto.ProductReviewForm;
import rating.app.service.ProductService;

@Controller
@RequestMapping(path = "/products")
public class ProductReviewController {
    private final ProductService service;

    @Autowired
    public ProductReviewController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/add_review")
    public String getReviewMenu(Model model) {
        model.addAttribute("reviewForm", new ProductReviewForm());
        return "addReview";
    }

    @PostMapping("/add_review")
    public String submitReview(@ModelAttribute("reviewForm") ProductReviewForm productReview, Model model, BindingResult result) {
        model.addAttribute(productReview);
        service.addReview(productReview);
        return "reviewAccepted";
    }

    @GetMapping("/get_rating")
    public String getProductRating(@RequestParam(name = "id") long id, Model model) {
        ProductDto productDto = service.getProductDto(id);
        model.addAttribute("productDto", productDto);
        return "productRating";
    }
}
