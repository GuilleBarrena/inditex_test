package com.inditex.guillermobarrena.inditex.repositories.facades;

import com.inditex.guillermobarrena.inditex.domain.Price;

import java.sql.Timestamp;
import java.util.List;

public interface IPriceRepositoryFacade {
    List<Price> findAll();
    Price findFirst(Integer brandId, Integer productId, Timestamp startDate, Timestamp endDate);
}
