package com.kononikhin.crud.services;

import com.kononikhin.crud.Exceptions.EntityNotFoundException;
import com.kononikhin.crud.Exceptions.WrongFilterException;
import com.kononikhin.crud.models.Product;
import com.kononikhin.crud.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";

    private final ProductRepository productRepository;
    private final CurrencyService currencyService;

    public ProductService(ProductRepository productRepository, CurrencyService currencyService) {
        this.productRepository = productRepository;
        this.currencyService = currencyService;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getById(Long id) throws EntityNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Product.class.getSimpleName(), id));
    }

    public void deleteProduct(Long id) {
        var productToDelete = productRepository.getById(id);
        productRepository.delete(productToDelete);
    }

    public List<Product> findByParameter(String paramName, String paramValue) throws WrongFilterException {
        if (paramName.equalsIgnoreCase(NAME)) {
            var resp = productRepository.findByNameContaining(paramValue);
            return resp;
        } else if (paramName.equalsIgnoreCase(DESCRIPTION)) {
            var resp = productRepository.findByDescriptionContaining(paramValue);
            return resp;
        } else {
            throw new WrongFilterException(paramName);
        }

    }
}
