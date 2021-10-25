package com.kononikhin.crud.controllers;


import com.kononikhin.crud.Exceptions.EntityNotFoundException;
import com.kononikhin.crud.Exceptions.WrongFilterException;
import com.kononikhin.crud.models.Product;
import com.kononikhin.crud.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"*","find/*"})
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

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws EntityNotFoundException {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping("")
    public void createProduct(@RequestBody Product product) throws EntityNotFoundException {
        productService.saveProduct(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productToUpdate) throws EntityNotFoundException {

        var dbProduct = productService.getById(id);
        dbProduct.frontProductToDbProduct(productToUpdate);
        var updatedProduct = productService.saveProduct(dbProduct);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("find/{param}/{value}")
    public List<Product> findProductsByFilter(@PathVariable String param, @PathVariable String value) throws WrongFilterException {
        return productService.findByParameter(param, value);
    }
}
