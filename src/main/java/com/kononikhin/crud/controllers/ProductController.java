package com.kononikhin.crud.controllers;


import com.kononikhin.crud.Exceptions.EntityNotFoundException;
import com.kononikhin.crud.models.Product;
import com.kononikhin.crud.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/products/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("getProduct")
    public Product getById(@PathVariable Long id) throws EntityNotFoundException {
        return productService.getById(id);
    }

//    @PostMapping("saveProduct")
//    public void saveProduct(@RequestBody Product product) {
//        productService.saveProduct(product);
//    }

    @PostMapping("")
    public void createProduct(@RequestBody Product product) throws EntityNotFoundException {
        productService.saveProduct(product);
    }
}
