package com.kononikhin.crud.services;

import com.kononikhin.crud.Exceptions.EntityNotFoundException;
import com.kononikhin.crud.models.Product;
import com.kononikhin.crud.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CurrencyService currencyService;

    public ProductService(ProductRepository productRepository, CurrencyService currencyService) {
        this.productRepository = productRepository;
        this.currencyService = currencyService;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) throws EntityNotFoundException {

        return productRepository.save(product);

    }

    public Product getById(Long id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class.getSimpleName(), id));
    }
}
