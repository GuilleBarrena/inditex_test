package com.inditex.guillermobarrena.inditex.services.impl;

import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.repositories.facades.IPriceRepositoryFacade;
import com.inditex.guillermobarrena.inditex.services.IPricesService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PricesServiceImpl implements IPricesService {

    private final IPriceRepositoryFacade facade;

    public PricesServiceImpl(IPriceRepositoryFacade facade) {
        this.facade = facade;
    }

    // Initialize facade
    @Override
    public List<Price> getAll() {
        return this.facade.findAll();
    }

    @Override
    public Price findOne(Price price) {
        Price loaded = this.facade.findFirst(price.getBrandId(), price.getProductId(), price.getStartDate(), price.getEndDate());
        if (loaded == null) {
            // Throw error
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "price not found"
            );
        }
        return loaded;
    }
}
