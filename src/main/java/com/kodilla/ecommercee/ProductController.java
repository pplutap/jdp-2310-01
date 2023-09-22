package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<ProductDto> getProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "productId")
    public ProductDto getProduct(Long ProductId) {
        return new ProductDto(0005L, "Czapka", "Czapka z daszkiem", 100L);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "productId")
    public void deleteProduct(Long ProductId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "")
    public ProductDto updateProduct(ProductDto productDto) {
        return new ProductDto(0005L, "CzapkaX", "Czapka z daszkiem z nadrukiem X", 110L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void createProduct(ProductDto productDto) {

    }
}
