package com.inditex.guillermobarrena.inditex.services.impl;

import com.inditex.guillermobarrena.inditex.Data;
import com.inditex.guillermobarrena.inditex.domain.Price;
import com.inditex.guillermobarrena.inditex.repositories.facades.IPriceRepositoryFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceTest {
    @Mock
    IPriceRepositoryFacade facade;
    @InjectMocks
    PricesServiceImpl service;

    @Test
    void getAll() {
        List<Price> list = List.of(
                Data.price_1,
                Data.price_2,
                Data.price_3,
                Data.price_4
        );
        when(facade.findAll()).thenReturn(list);
        assertEquals(service.getAll(), list);
    }

    @Test
    void findOne() {
        Price testPrice = Data.price_1;
        assertEquals(testPrice, Data.price_1);
    }
}