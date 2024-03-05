package com.springecommerce.service;

import com.springecommerce.entity.Product;
import com.springecommerce.error.ProductNotFoundException;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId) throws ProductNotFoundException;

    List<Product> searchProducts(String keyword, String category, Integer minPrice, Integer maxPrice);

    Product updateProductById(Long productId, Product product) throws ProductNotFoundException;
}
