package com.inditex.guillermobarrena.inditex.services;

import com.inditex.guillermobarrena.inditex.domain.Price;

import java.util.List;

public interface IPricesService {
    List<Price> getAll();
    Price findOne(Price price);
}
