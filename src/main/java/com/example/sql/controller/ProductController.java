package com.example.sql.controller;


import com.example.sql.entity.Product;
import com.example.sql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController
{
    @Autowired
    private ProductService productService;


    @PostMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/productsMultiple")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> findProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductsById(id);
    }

    @GetMapping("/products/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @PutMapping("/products")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

}
