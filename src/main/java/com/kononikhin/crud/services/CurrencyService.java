package com.kononikhin.crud.services;

import com.kononikhin.crud.Exceptions.EntityNotFoundException;
import com.kononikhin.crud.models.Currency;
import com.kononikhin.crud.repositories.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

    public Currency getById(Long id) throws EntityNotFoundException {
        return currencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Currency.class.getSimpleName(), id));
    }
}
