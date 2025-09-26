package com.subham.SpringSecurity.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private record Product(Integer ProductId, String productName, double price) {
    }

    List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Laptop", 35.000),
            new Product(2, "Phone", 15.000)
    ));

    @GetMapping
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        products.add(product);
        return product;
    }
}
