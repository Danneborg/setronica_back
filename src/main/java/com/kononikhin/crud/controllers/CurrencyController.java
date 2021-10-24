package com.kononikhin.crud.controllers;

import com.kononikhin.crud.models.Currency;
import com.kononikhin.crud.services.CurrencyService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/add-product")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/currency/")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("getAllCurrencies")
    public List<Currency> getAllCurrencies() {
        return currencyService.getAll();
    }
}
